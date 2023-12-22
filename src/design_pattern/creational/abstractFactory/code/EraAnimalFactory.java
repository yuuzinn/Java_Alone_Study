package design_pattern.creational.abstractFactory.code;

public interface EraAnimalFactory {
    // 시대별로 육지와 하늘의 동물을 생성하는 방법을 선언하는 인터페이스
    LandAnimal makeLandAnimal();
    SkyAnimal makeSkyAnimal();
}
