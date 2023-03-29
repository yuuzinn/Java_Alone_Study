package Kevin_Stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamplesTest01 {

    private static void slowDown() {
        try {
            TimeUnit.MILLISECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long iterativeSum(long n) {
        /*
        사실 실용적인 코드는 아님.
         */
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
                .peek(i -> slowDown()) // forEach랑 비슷함. forEach(최종연산) 는 return 후 끝나버리는데 peek() (중개연산) 는 return X // slowDown() 메서드는 void 타입이라 딱 맞음.
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
        System.out.println("     iterativeSum(n): " + iterativeSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start1) + " ms\n");
        final long start2 = System.currentTimeMillis();
        System.out.println("    sequentialSum(n): " + sequentialSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start2) + " ms\n");
        final long start3 = System.currentTimeMillis();
        System.out.println("      parallelSum(n): " + parallelSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start3) + " ms\n");
        // start3 (parallelSum) 느린 이유...?
        /**
         * .iterate(1L, i -> i + 1) : 1L 부터 시작하여 처음 i에 1L가 들어가고, 연산(i + 1)을 하여 2L로 만들고... 반복.
         *  parallel로 만들면, 1, 2, 3, 4 ... 이것들을 쪼개는 방식(병렬)으로 되는데... .iterate(1L, i -> i + 1) 로직에서,
         *  이전값이 있어야만 다음 연산을 할 수 있음. 근데 다른 코어(thread)들이 자기도 계산을 하려 값을 찾아봤는데 못찾음. (아직 안 들어와서)
         *  1,      2,        3,        4 ... ... n-1       n
         *  |       |         |         |   ...    |        |
         *  계산    계산       ..                   ?(전값 못찾음)
         *  못찾아서 스레드들은 기다리게 되고 그만큼 느려지는 것. 그래서 해당 로직에서는 느려질 수밖에 없음 (parallel()을 쓴다고 무조건 느린 건 아님)
         *
         *  --------
         * slowDown() 메서드를 사용한 후 가장 빠름. 오히려 다른 start1, 2, 4 가 급격히 느려짐.
         * peek() function 이 오래 걸리다 보니 parallel()이 연산을 빨리빨리 도와줌.
         */
        final long start4 = System.currentTimeMillis();
        System.out.println("        rangedSum(n): " + rangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start4) + " ms\n");
        final long start5 = System.currentTimeMillis();
        System.out.println("parallelRangedSum(n): " + parallelRangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start5) + " ms\n");
        // rangeClosed()에서도..
        /**
         * 1부터 n(해당 예제에서는 100만)까지 다 저장해놓는 것이 아님.
         * 1부터 100만 까지 예를 들어, 코어가 4개면 4등분해서 각각 계산 후 합치는 것이 아니라 그 안에서 무수히(적당히) 나뉘어서 계산하다가
         * 합치고, 또 나눠서 합치고.. 이런 과정이 계속해서 반복이 되는 것. 근데 순차적으로 합치는 게 아님. 스레드들이 어느정도 나눠서
         * 예를 들어 뭐.. 1 ~ 50까지 더한 값과 151 ~ 200까지 더한 값을 먼저 합치고 그런.. 그렇게 지지고 볶고 합쳐서 최종적인 결과가 나옴.
         * 결국 순서는 보장이 안 된다는 말과 같음.
         * 쪼개고 합치고 쪼개고 합치고는 computing power 를 낭비하기 쉬움. 그래서 시간이 더 걸리는 것 ㅇㅇ (물론 start3보단 아님)
         *
         * 여기서 효율적으로 parallel()을 쓰고 싶다면 중개연산으로 map()이나 filter() 등등.. 쓰게 되면 빛을 보게 됨.
         *  map()이나 filter() 이 둘은 계산하는 데에 시간이 오래 걸리기 때문에
         *
         *  // slowDown() 메서드를 사용한 후 가장 빠름.
         * peek() function 이 오래 걸리다 보니 parallel()이 연산을 빨리빨리 도와줌.
         **/
    }
}
