package JavaOfGod.version2.ch20;

public class JavaLangSystem {
    public static void main(String[] args) {
        JavaLangSystem sample = new JavaLangSystem();
        sample.systemPropertiesCheck();
    }

    public void systemPropertiesCheck() {
        System.out.println("java.version = " + System.getProperty("java.version"));
        System.out.println("JAVA_HOME =" + System.getenv("JAVA_HOME"));
    }
    public void numberMinMaxElapsedCheck() {
        JavaLangNumber numberSample = new JavaLangNumber();
        long startTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        System.out.println("Milliseconds = " + (System.currentTimeMillis() - startTime));
        System.out.println("Nanoseconds = " + (System.nanoTime() - endTime));
    }
}
