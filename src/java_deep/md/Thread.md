## Thread

### Java를 사용하여 Multi Thread 환경에서 개발 시 고려해야하는 점은 무엇인가 ?

멀티 스레드 환경에서 고려해야하는 부분으로 Field member, 동기화(동시성), ThreadLocal이 있다.

Field member란 ? class에 변수를 정의하는 공안을 의미한다. 이곳에 변수를 만들면 메서드끼리 변수를 주고 받는데
있어서 참조가 쉬워진다.

하지만 객체가 여러 스레드가 접근하는 싱글톤 객체라면, field에서 상태값을 갖고 있을 경우 각각의 스레드에 영향을 줄 수 있기 때문에 상태값을 갖고 있으면 안 된다.

모든 변수를 Parameter로 넘겨 받고 return 하는 방식으로 Code를 작성하는 것이 멀티스레드 환경에서 필요하다.

만약, 변수가 **Atomic Type**과 같은 동기화 문제 해결이 보장되는 상황에선 위의 내용들이 강제성을 띄지 않는다.

Atomic 변수는 멀티스레드 환경에서 동기화 문제를 해결하기 위해 Synchronized 키워드를 이용해 Lock를 걸곤 하는데, 이런 키워드 없이 동기화 문제를 해결하기 위해 고안된 방법이다.


field에 Collection이 필요한 경우 Java에서는 Synchronized 키워드를 사용하여 스레드 간 Race Condition을 통제하게 된다. Collections라는 util 클래스에서 제공되는 static 메서드를 통해
일반적인 List, Set, Map이 아닌 Collections.synchronizedList(), ...Set(), ...Map()을 사용할 수 있따.
JDK 1.7부터는 Concurrent Package를 통해 ConcurrentHashMap이라는 구현체를 제공한다. Collections util을 사용하는 것보다 Synchronized 키워드가 적용된 범위가 좁아 보다 좋은 성능을 낼 수 있다.


멀티 스레드 환경에서 일반적인 Map(HashMap)을 사용했을 경우 Out Of Memory를 유발할 가능성이 있다. 여러 스레드가 동시에 Map에 접근하는 메서드를 호출하게 되면
Synchronized 블록을 사용하지 않은 경우 Map 내부 값들과 연결되는 Reference가 올바르게 연결되지 않게 된다.
이런 경우 Reference가 남은 객체는 GC가 처리할 수 없어 Memory를 계속 차지하게 되고, 이러한 일이 반복된다면 결국 Memory 부족 오류가 발생하게 된다.

마지막으로 ThreadLocal은 Thread 사이에 간섭이 없어야 하는 데이터에 사용한다. 멀티 스레드 환경에서는 Class의 Field에 member를 추가할 수 없고 매개변수로 넘겨받아야 하기 때문이다.
즉, 스레드 내부의 싱글톤을 사용하기 위해 사용하며 주로 사용자 인증, 세션 정보, 트랜잭션 컨텍스트에 사용한다. 스레드 풀 환경에서 ThreadLocal을 사용하는 경우 ThreadLocal 변수에 보관된 데이터의 사용이 
끝나면 반드시 해당 데이터를 삭제해 주어야 하며, 그렇지 않을 경우 재사용되는 Thread가 올바르지 않은 데이터를 참조할 수 있다.

