package spring.ch06.strategyPattern;

public class StrategyGun implements Strategy{
    @Override
    public void runStrategy() {
        System.out.println("땅 땅 땅 빵");
    }
}
