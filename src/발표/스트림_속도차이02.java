package 발표;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * int numOfCores = Runtime.getRuntime().availableProcessors(); // 본인 컴퓨터 코어(논리 프로세서)개수 찾는 로직.
 *  System.out.println(numOfCores);
 */
public class 스트림_속도차이02 {

    private static void slowDown() {
        try {
            TimeUnit.MILLISECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static long iterativeSum(long n) {

        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
            slowDown(); // 추가
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .get();
    }

    public static long parallelSum(long n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .get();
    }

    public static long rangedSum(long n) {
        return LongStream
                .rangeClosed(1, n)
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream
                .rangeClosed(1, n)
                .parallel()
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .getAsLong();
    }

    public static void main(String[] args) {
        final long n = 1_000; // 1_000
        final long start1 = System.currentTimeMillis();
        System.out.println("     iterativeSum(n): " + iterativeSum(n)); // 1 for
        System.out.println("                      " + (System.currentTimeMillis() - start1) + " ms\n");
        final long start2 = System.currentTimeMillis();
        System.out.println("    sequentialSum(n): " + sequentialSum(n)); // 2 iter
        System.out.println("                      " + (System.currentTimeMillis() - start2) + " ms\n");
        final long start3 = System.currentTimeMillis(); // 3 parallel iter
        System.out.println("      parallelSum(n): " + parallelSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start3) + " ms\n");
        final long start4 = System.currentTimeMillis(); // 4 range
        System.out.println("        rangedSum(n): " + rangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start4) + " ms\n");
        final long start5 = System.currentTimeMillis(); // 5 parallel rang
        System.out.println("parallelRangedSum(n): " + parallelRangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start5) + " ms\n");

    }
}
