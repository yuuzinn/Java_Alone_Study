package spring.ch06.proxyPattern;

public class IServiceImpl implements IService{
    @Override
    public String runSomething() {
        return "프록시 서비스 좋네요.";
    }
}
