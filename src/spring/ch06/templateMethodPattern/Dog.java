package spring.ch06.templateMethodPattern;

public class Dog extends Animal{

    // abstract method override
    @Override
    void play() {
        System.out.println("멍 ! 멍 !");
    }

    // hook (갈고리) method
    @Override
    void runSomething() {
        System.out.println("멍 ! 멍 !~ 꼬리 살랑~살랑~");
    }
}
