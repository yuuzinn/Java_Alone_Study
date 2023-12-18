package design_pattern.creational.FactoryMethod.code;

public class Dog extends Animal{
    @Override
    AnimalToy getToy() {
        return new DogToy();
    }
}
