## Generic

### Generic에 대해 설명할 수 있는가 ?

Generic Type을 이용해서 Compile 과정에서 Type Checking이 가능하다.
Generic은 Class와 Interface, method를 정의할 때 Type Parameter로 사용한다.

Generic을 사용하는 이유이자 장점은

1. Compile할 때 **Type Checking을 해서 Error를 사전**에 잡을 수 있다.
2. Compiler가 **TypeCasting을 해주기 때문**에 개발자가 편리하다.
3. Type만 다르고 Code의 내용이 대부분 일치할 때, **코드의 재사용성**이 좋아진다.

```java
public class className<T> {...}

public interface interfaceName<T> {...}
```

>클래스와 Interface에서 Generic TypeParameter 사용법은 아래와 같다.

하지만 실제 사용 시에는 Type Parameter에 구체적인 Type을 명시해야한다.

```java
ArrayList<String> list = new ArrayList<String>();
```
- ArrayList에 String 값만 저장할 수 있도록 구체적인 Type 지정

>Multi Type Parameter
```java
HashMap<String, Object> map = new HashMap<String, Object>();
```
Generic Type을 2개 이상 만들 수 있다.
HashMap <key, value>로 Generic Type을 사용하고 있다.

> Generic Method

매개변수 Type과 Return Type으로 TypeParameter를 갖는 메서드이다.
Generic Class가 아니더라도 메서드만 Generic 메서드일 수 있다.

```java
public <T> Product<T> boxing(T t) {...}
```

- 제한된 Type Parameter 
  - `<T extends Type>` <br>
  Type Parameter에 지정되는 구체적인 Type 제한할 필요가 있을 때가 있다.
예를 들어, 숫자 연산 Generic Method는 Byte, Short, Integer, Long ,Double 인스턴스만 가져야 한다. 이럴 때 Number Type으로 제한한다.
  - `<T extends Number>` <br>
Number Type 또는 Number Type 하위 클래스(확장) Type만 올 수 있다. `<T super Type>`으로 상위 클래스도 표현가능하지만
`<T implements Type>`같은 표현은 없다. 만약 Interface로 제한하고 싶을지라도 `extends`를 사용해야한다.