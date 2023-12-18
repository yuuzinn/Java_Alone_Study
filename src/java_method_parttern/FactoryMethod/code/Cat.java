package java_method_parttern.FactoryMethod.code;

public class Cat extends Animal{
    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
