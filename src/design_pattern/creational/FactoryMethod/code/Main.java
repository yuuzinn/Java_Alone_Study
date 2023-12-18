package design_pattern.creational.FactoryMethod.code;

public class Main {
    public static void main(String[] args) {
        // Factory Method를 보유한 객체 생성
        Animal dog = new Dog();
        Animal cat = new Cat();
        // Factory Method가 반환하는 객체 생성
        AnimalToy dogToy = dog.getToy();
        AnimalToy catToy = cat.getToy();
        // Factory Method가 반환한 객체를 사용
        dogToy.identify();
        catToy.identify();
    }
}
