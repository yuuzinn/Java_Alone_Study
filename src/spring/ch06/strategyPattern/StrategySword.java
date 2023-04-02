package spring.ch06.strategyPattern;

public class StrategySword implements Strategy{
    @Override
    public void runStrategy() {
        System.out.println("쉭..쉬쉭..쉬..쉬쉭..");
    }
}
