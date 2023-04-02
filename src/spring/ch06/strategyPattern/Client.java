package spring.ch06.strategyPattern;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = null;
        Soldier rambo = new Soldier();

        // 총을 rambo 에게 전달하여 전투 수행
        strategy = new StrategyGun();
        rambo.runContext(strategy);

        System.out.println();

        // 검을 --
        strategy = new StrategySword();
        rambo.runContext(strategy);

        System.out.println();

        // 활을 --
        strategy = new StrategyBow();
        rambo.runContext(strategy);
    }

    /**
     * 전투 시작
     * 땅 땅 땅 빵
     * 전투 종료
     *
     * 전투 시작
     * 쉭..쉬쉭..쉬..쉬쉭..
     * 전투 종료
     *
     * 전투 시작
     * (대충 활시위 당기는 짤) 피융ㅇ피융 퓩퓩퓩 크악 ㅋㅋ
     * 전투 종료
     */
}
