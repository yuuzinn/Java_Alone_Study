package JavaOfGod.version2.ch25;

public class DaemonThread extends Thread {
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void runCommonThread() {
        DaemonThread thread = new DaemonThread();
        System.out.println("runCommonThread() 시작 됐어요");
        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) {
        DaemonThread test = new DaemonThread();
        test.runCommonThread();
    }
}
