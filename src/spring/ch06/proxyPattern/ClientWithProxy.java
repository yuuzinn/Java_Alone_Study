package spring.ch06.proxyPattern;

public class ClientWithProxy {
    public static void main(String[] args) {
        IService proxy = new Proxy();
        System.out.println(proxy.runSomething());
    }
    // 데코레이터 패턴도 프록시 패턴과 동일하지만, 프록시 패턴은 리턴값을 그대로 전달해주는 반면에
    // 데코레이터 패턴은 리턴값에 덧입혀서 전달해주는 패턴이다.
}
