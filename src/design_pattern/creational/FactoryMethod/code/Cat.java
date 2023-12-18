package design_pattern.creational.FactoryMethod.code;

public class Cat extends Animal{
    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
