package design_pattern.creational.abstractFactory.code;

public class MesozoicAnimalFactory implements EraAnimalFactory {
    // 중생대 동물 만드는 Factory

    @Override
    public LandAnimal makeLandAnimal() {
        return new LandAnimal(AnimalEra.MESOZOIC, "중생대 티라노");
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
        return new SkyAnimal(AnimalEra.MESOZOIC, "중생대 익룡");
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
