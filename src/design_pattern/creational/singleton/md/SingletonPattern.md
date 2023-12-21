> "클래스의 인스턴스, 즉 객체를 하나만 만들어 사용하는 패턴" - Spring 입문

오직 하나의 인스턴스만 만들고 그것을 계속해 사용해 나간다.

싱글턴 패턴의 경우, 두 개의 객체는 존재할 수 없다. 이는 객체 생성을 위한 new 연산자에 제한을 걸어두어야만 한다.

만들어진 단일 객체를 반환할 수 있는 메서드도 필요하다. 아래의 조건들을 통해 코드를 작성해 보자.

- new를 실행할 수 없도록 생성자에 private 접근 제어자를 걸어두자.
- 유일한 단일 객체를 반환할 수 있는 정적 메서드가 필요하다.
- 유일한 단일 객체를 참조할 수 있는 정적 참조 변수가 필요하다.

코드 참조.

```java
public class Singleton {
    static Singleton singletonObject; // 정적 참조 변수
    private Singleton() {} // private 생성자
    // 객체 반환 정적 메서드
    public static Singleton getInstance() {
        if (singletonObject == null) {
            singletonObject = new Singleton();
        }
        return singletonObject;
    }
}
```

- private 생성자를 갖는다.
- 단일 객체 참조 변수를 정적 속성으로 갖는다.
- 단일 객체 참조 변수가 단일 객체를 반환하는 getInstance() 정적 메서드를 갖는다.
- 단일 객체는 쓰기 가능한 속성을 갖지 않는 것이 정석이다.

