package design_pattern.creational.singleton.code;

public class Main {
    public static void main(String[] args) {
//        Singleton obj = new Singleton(); 생성 불가능 (private)
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        /**
         design_pattern.creational.singleton.code.Singleton@4eec7777
         design_pattern.creational.singleton.code.Singleton@4eec7777
         design_pattern.creational.singleton.code.Singleton@4eec7777
         */
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
