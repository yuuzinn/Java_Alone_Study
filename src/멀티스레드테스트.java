class 스레드테스트 extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("스레드테스트");
        }
    }
}
public class 멀티스레드테스트 {
    public static void main(String[] args) {
        스레드테스트 test = new 스레드테스트();
        test.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("멀티스레드테스트");
        }
    }
}
