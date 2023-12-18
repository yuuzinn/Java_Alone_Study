package design_pattern.creational.FactoryMethod.code;

public class CatToy extends AnimalToy{
    @Override
    void identify() {
        System.out.println("나는 캣타워야~~");
    }
}
