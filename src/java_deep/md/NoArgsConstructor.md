이전에 분명히 정리해서 기억했던 거 같은데, 문득 다시 생각해 보니 또 기억이 가물가물해져서 이참에 다시 한번 정리해봐야겠어요.


### 왜 쓰는가?

보통 Entity or DTO Class에서 주로 사용했어요. 실제로 팀 프로젝트에서도 많이 사용했었고, 제한을 두었거든요.

기본 생성자의 접근 제어를 PROTECTED로 지정하게 둔다면, 객체 생성에 있어서 한번 더 Check 할 수 있게 돼요.


예를 든다면, 세 개의 Field를 갖는 Entity 가 있는데, 세 Field를 갖는 객체를 만들려 해요. 지정해 두지 않게 된다면, Setter(예시)를 통해서 한 개든, 두 개든, 세 개든. 무분별한 객체 생성을 막아줄 수 있거든요.
```java
@Getter
@Setter
@NoArgsConstructor
public class Test {
    private Long testId;
    private String name;
    private String password;
}


public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.setName("testName");
        test.setPassword("1234");
    }
}
```

그래서 Entity(DTO) 내에서 생성자를 따로 Custom하게 만들어서, 외부에서 함부로 적용할 수 없게끔 만드는 것은, 조금 더 깔끔하고 수월한 작업을 만들어 주는 데에 있어 큰 가치가 있어요.


여기에 추가적으로, PROTECTED를 걸어 두어 생성하게 된다면 내부적으로 Compile 당시 아래와 같이 기본 생성자가 컴파일 되어요.
```java
protected Test() {}
```
