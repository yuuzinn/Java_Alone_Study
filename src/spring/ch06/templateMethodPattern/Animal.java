package spring.ch06.templateMethodPattern;

public abstract class Animal {
    // template method
    public void playWithOwner() {
        System.out.println("귀염둥이 이리온 ~");
        play();
        runSomething();
        System.out.println("잘했어");
    }
    // abstract method
    abstract void play();

    // hook(갈고리) method
    void runSomething() {
        System.out.println("꼬리 살랑 살랑~~");
    }
}
