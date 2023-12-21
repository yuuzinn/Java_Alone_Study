package design_pattern.creational.factoryMethod.code;

public class DogToy extends AnimalToy{
    @Override
    void identify() {
        System.out.println("나는 테니스 공 ! 강아지의 친구 !");
    }
}
