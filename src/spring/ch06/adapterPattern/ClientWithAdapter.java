package spring.ch06.adapterPattern;

/**
 * Adapter pattern -> 합성. 객체를 속성으로 만들어서 참조하는 디자인 패턴이다.
 * 호출당하는 쪽의 메서드를 호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해 호출하는 패턴임.
 * AdapterService A, B (변환기) 를 통해 runService() 동일 메서드로 두 객체의 메서드를 호출함.
 */

public class ClientWithAdapter {
    public static void main(String[] args) {
        AdapterServiceA asa1 = new AdapterServiceA();
        AdapterServiceB asb1 = new AdapterServiceB();

        asa1.runService();
        asb1.runService();
    }
}
