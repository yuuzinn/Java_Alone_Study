package JavaOfGod.version1.결합도;

public class 결합도_01 {
    String name;
    String mail;

    public 결합도_01() {}

    public 결합도_01(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    /**
     * 모듈들이 parameter 등을 통해 data 를 공유하는 경우.
     */
    public void 자료결합도() {
        int result = zegop(5);
    }
    public int zegop(int x) {
        return x * x;
    }

    public void 스탬프결합도() {
        결합도_01 스탬프결합도 = new 결합도_01("yeb0", "wsh05925@naver.com");
        sendMail();
    }
    public void sendMail() {
        System.out.println(name + " " +mail);
    }


}
