package design_pattern.creational.abstractFactory.code;

public class AnimalAbstractFactory {
    Animal animal;
    Animal createAnimal(AnimalType type) {
        AnimalEra era = getFromConfiguration();
        switch (era) {
            case MESOZOIC -> animal = new MesozoicAnimalFactory().createAnimal(type);
            case CENOZOIC -> animal = new CenozoicAnimalFactory().createAnimal(type);
        }
        return animal;
    }
    AnimalEra getFromConfiguration() {
        return AnimalEra.MESOZOIC; // default
    }
}
