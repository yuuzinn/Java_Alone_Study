# Object Mapper ?

> 프로젝트 하던 중에 Json을 받아와 필요한 데이터들을 DTO에 변환하는 작업이 필요했다.<br>
> 우리 팀은 RestTemplate와 Object Mapper를 사용하기로 정했는데, 당시에는 구현하기 급급해서<br>
> 사용법만 익혔었다. 이번 기회에 알아보도록 하자.

### Object Mapper 는 무엇인가?

- Json 형식의 데이터를 Java 객체로 deserialization 하거나, Java 객체를 Json으로 serialization 할 때 사용하는 Jackson 라이브러리 클래스이다.
- ObjectMapper는 생성 비용이 비싸기 때문에 bean이나 static으로 처리하는 것이 좋다.

왜 그렇게 처리하는 것이 좋은가 ? [Object Mapper 재사용에 관련한 이슈](https://github.com/deeplearning4j/deeplearning4j/issues/2170)를
보면 Jackson의 ObjectMapper 를 생성하는 것은(새 인스턴스 생성) 비용이 많이 들기 때문에 성능을 저하시키는 요인이 된다.

그리고 [ObjectMapper는 Thread Safe](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html)하다.

> Mapper instances are fully thread-safe provided that ALL configuration of the instance occurs before ANY read or write calls. <br> 
> 인스턴스의 모든 구성이 읽기 또는 쓰기 호출 전에 발생하는 경우 매핑기 인스턴스는 완전히 스레드 안전합니다

Thread Safe 하다는 것을 보고 찾아 보게 되었는데, 예전 2.8.7 버전 이전에는 내부적으로 Synchronized 블록이 있어 lock으로 인한 
성능 저하가 있었다 했다. ObjectMapper 내부의 Synchronized 블록으로 인해 Multi Thread 성능 이슈를 발견하고, 해결한 분이 작성한 글을 가져왔다.
https://github.com/FasterXML/jackson-core/issues/349

2.8.7버전 이후로는 해당 블록이 삭제되었다고 한다.

