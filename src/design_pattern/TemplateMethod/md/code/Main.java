package design_pattern.TemplateMethod.md.code;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.playWithOwner();

        System.out.println("----------");

        cat.playWithOwner();

        System.out.println("----------");


    }
}
