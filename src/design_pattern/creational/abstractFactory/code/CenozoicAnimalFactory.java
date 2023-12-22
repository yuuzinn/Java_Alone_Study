package design_pattern.creational.abstractFactory.code;

public class CenozoicAnimalFactory implements EraAnimalFactory{
    // 신생대 동물 만드는 Factory
    @Override
    public LandAnimal makeLandAnimal() {
        return new LandAnimal(AnimalEra.CENOZOIC, "신생대 티라노");
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
        return new SkyAnimal(AnimalEra.CENOZOIC, "신생대 익룡");
    }
    Animal createAnimal(AnimalType type) {
        switch (type) {
            case LAND -> {
                return makeLandAnimal();
            }
            case SKY -> {
                return makeSkyAnimal();
            }
        }
        return null;
    }
}
