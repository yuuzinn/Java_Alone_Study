package design_pattern.creational.abstractFactory.code;

public class Main {
    public static void main(String[] args) {
        new AnimalAbstractFactory().createAnimal(AnimalType.LAND);
    }
}
