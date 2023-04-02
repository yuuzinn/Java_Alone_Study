package spring.ch06.singletonPattern;

public class Client {
    public static void main(String[] args) {
        // private 생성자라 new로 인스턴스 생성 불가능
        // Singleton s = new Singleton(); <- 불가능
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        s1 = null;
        s2 = null;
        s3 = null;
    }
}
