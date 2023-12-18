package design_pattern.TemplateMethod.md.code;

public class Dog extends Animal{
    public void playWithOwner() {
        System.out.println("이리와 !");
        play();
        runSomething();
        System.out.println("굿잡");
    }
    @Override
    void play() {
        System.out.println("멍 ! 멍 !");
    }
    @Override
    void runSomething() {
        System.out.println("강아지 꼬리 팔랑팔랑");
    }
}
