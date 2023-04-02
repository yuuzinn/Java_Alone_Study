package spring.expert001_01;

/**
 * 프로그래밍에서 의존 관계는 new 로 표현된다 !
 */

public class Driver {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getTireBrand());
    }
}
