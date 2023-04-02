package spring.ch06.templateMethodPattern;

public class Driver {
    public static void main(String[] args) {
        Animal bomi = new Dog();
        Animal kitty = new Cat();

        bomi.playWithOwner();

        System.out.println();
        System.out.println();

        kitty.playWithOwner();
    }
    // 템플릿 메서드 - 공통 로직을 수행, 로직 중에 하위 클래스에서 오버라이딩한 추상 메서드/훅 메서드 호출 - playWithOwner();
    // 템플릿 메서드에서 호출하는 메서드 - 하위 클래스가 반드시 오버라이딩 해줘야함. - play()
    // 템플릿 메서드에서 호출하는 훅 메서드 - 하위 클래스가 선택적으로 오버라이딩 할 수 있음. - runSomething()
}
