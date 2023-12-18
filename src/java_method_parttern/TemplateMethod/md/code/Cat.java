package java_method_parttern.TemplateMethod.md.code;

public class Cat extends Animal{
    public void playWithOwner() {
        System.out.println("이리와 !");
        play();
        runSomething(); // Hook Method none overriding -> Animal method
        System.out.println("굿잡");
    }
    @Override
    void play() {
        System.out.println("야옹 야옹");
    }
}
