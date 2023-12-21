package design_pattern.creational.factoryMethod.code;

public class Cat extends Animal{
    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
