> "구체적인 클래스를 지정하지 않고, 관련 or 종속 개체군을 생성하기 위한 인터페이스 제공" - Design Patterns: Elements of Reusable Object-Oriented Software

Abstract Factory Pattern 을 사용하면 일반적인 패턴을 따르는 객체를 만들 수 있다.

code 부분은 code directory 참조

---

Abstract Factory Pattern 을 사용하는 이유 ? 

- Client 는 이러한 System에서 객체를 생성하고 구성하는 방법에 대해 독립적이다.
- System은 여러 객체 계열로 구성되고, 이러한 계열은 함께 사용되도록 설계되어 있다.
- 특정 종속성을 구성하려면 Runtime 값이 필요하다.

미리 정의된 객체들에 대해 만들 때는 훌륭한 Pattern이나, **새 개체를 추가하는 것은 매우 번거로운 일이다. 복잡도는 늘어날 것이고, Abstarct Factory Class와 모든 하위 클래스를 변경해야만 한다.**

