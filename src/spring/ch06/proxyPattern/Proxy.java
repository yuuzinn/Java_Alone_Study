package spring.ch06.proxyPattern;

public class Proxy implements IService{
    IService service1;
    @Override
    public String runSomething() {
        System.out.println("호출에 대한 흐름 제어가 주목적이며 리턴을 그대로 전달합니다.");

        service1 = new IServiceImpl();
        return service1.runSomething();
    }
}
