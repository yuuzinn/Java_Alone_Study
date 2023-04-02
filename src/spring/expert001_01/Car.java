package spring.expert001_01;

public class Car {
    Tire tire;

    public Car() {
        tire = new KoreaTire(); // new.. . 의존관계가 일어나고 있는 부분이다.
    }
    public String getTireBrand() {
        return "장착된 타이어 : " + tire.getBrand();
    }
    /**
     * 자동차는 타이어에 의존한다.
     * 운전자는 자동차를 사용한다.
     * 운전자가 자동차에 의존한다고 봐도 된다.
     * 자동자츼 생성자 코드에서 tire 속성에 새로운 타이어를 생성해서 참조할 수 있게 해준다.
     */
}
