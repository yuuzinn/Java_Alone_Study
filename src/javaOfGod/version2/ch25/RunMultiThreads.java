package javaOfGod.version2.ch25;

public class RunMultiThreads {
    public static void main(String[] args) {
        RunMultiThreads sample = new RunMultiThreads();
        sample.runMultiThread();
    }

    public void runMultiThread() {
        RunnableSample[] runnable = new RunnableSample[5];
        ThreadSample[] thread = new ThreadSample[5];
        for (int i = 0; i < 5; i++) {
            runnable[i] = new RunnableSample();
            thread[i] = new ThreadSample();

            new Thread(runnable[i]).start();
            thread[i].start();
        }
        System.out.println("runMultiThread method is ended");
    }
}
