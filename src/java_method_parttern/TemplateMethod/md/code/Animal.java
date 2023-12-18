package java_method_parttern.TemplateMethod.md.code;

public abstract class Animal {
    public void playWithOwner() {
        System.out.println("이리와 !");
        play();
        runSomething();
        System.out.println("굿잡");
    }
    abstract void play(); // 추상 (Abstract Method)
    void runSomething() { // 훅 (Hook Method)
        System.out.println("꼬리를 흔들어요");
    }
}
