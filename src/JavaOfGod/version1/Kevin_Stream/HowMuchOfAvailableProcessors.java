package JavaOfGod.version1.Kevin_Stream;

public class HowMuchOfAvailableProcessors {
    public static void main(String[] args) {
        int numOfCores = Runtime.getRuntime().availableProcessors(); // 본인 컴퓨터 코어(논리 프로세서)개수 찾는 로직.

        System.out.println(numOfCores);
    }
}
