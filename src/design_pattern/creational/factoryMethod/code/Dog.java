package design_pattern.creational.factoryMethod.code;

public class Dog extends Animal{
    @Override
    AnimalToy getToy() {
        return new DogToy();
    }
}
