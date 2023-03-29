package spring.day1;

public class Driver {
    public static void main(String[] args) {
        Penguin pororo = new Penguin(); // 여기까지 실행할 경우, main 스택 프레임에 pororo 가 올라갈 것이고, 거기에 참조되는 힙 영역으로 Penguin 만 올라가는 게 아닌 Animal 도 같이 올라감.
        // 힙에 올라간다는 거는 즉, 하위 클래스의 인스턴스가 생성될 때 상위 클래스의 인스턴스도 같이 생성된다는 의미와 같다. 아주아주 중요한 내용이다.!!!!!
        // 그 말은 즉슨 모든 클래스의 상위 클래스인 Object 도 같이 생성된다는 이야기.
        // 이 코드들을 한글로 해석해 보자.
        // 📌펭귄 한 마리가 태어나니 펭귄 역할을 하는 pororo 라 이름을 지었다.📌
        pororo.name = "뽀로로";
        // pororo의 name을 "뽀로로"라 하자.
        pororo.habitat = "남극";
        // pororo의 habitat 를 "남극"이라 하자.

        pororo.showName();
        // pororo 야, 네 이름은?
        pororo.showHabitat();
        // pororo 야, 네 서식지는?

        Animal pingu = new Penguin();
        pingu.name = "핑구";
//        pingu.habitat = "EBS";

        pingu.showName();
//        pingu.showHabitat();

//        Penguin happyFeet = new Animal();
    }
}
