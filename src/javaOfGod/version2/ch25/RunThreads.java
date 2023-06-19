package javaOfGod.version2.ch25;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads threads = new RunThreads();
        threads.runBasic();
    }

    public void runBasic() {
        RunnableSample runnableSample = new RunnableSample();
        new Thread(runnableSample).start(); // new -> 1

        ThreadSample threadSample = new ThreadSample();
        threadSample.start(); // none -> 3
        System.out.println("RunThreads.runBasic() method is ended."); // -> 2
    }
}
