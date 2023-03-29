package 발표;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 1. 멀티 프로세스 ?
 * -> 여러 개의 프로세스가 서로 협력적으로 일을 처리하는 것. ( 밑의 예제 ) == 작업을 병렬처리 하는 것.
 * 각 프로세스 간 메모리의 구분이 필요하거나 독립된 주소 공간을 가져야 할 때 사용한다.
 *
 * 📌장점 ?
 * 독립된 구조이기에 안정성 높음, 여러 프로세스가 작업을 같이 하고 있어서 하나의 프로세스가 죽어도 문제가 확산되지 X (느려질 수는 있음. 죽은 프로세스만큼 일을 더 해야함)
 * 여러 개의 프로세스가 처리되어야 할 때, 동일한 데이터를 사용하며 이 데이터를 하나의 disk에 두고 모든 프로세서(cpu)가 이를 공유하면 비용적으로 저렴함.
 *
 * 📌단점 ?
 * 멀티 스레드보다 많은 메모리 공간과 cpu 시간을 차지함.
 * 독립된 메모리 영역이기에 작업량이 많을 수록 (*Context Switching이 자주 일어나서 주소 공간의 공유가 잦을 경우) 오버헤드가 발생하여 성능 저하 발생 우려
 * Context Switching 과정에서 캐시 메모리 초기화 등 무거운 작업이 진행되고 시간이 소모되는 등 오버헤드 발생.
 *
 * 📌Context Switching ?
 * cpu는 한 번에 하나의 프로세스만 실행 가능.
 * cpu에서 여러 프로세스를 돌아가면서 작업을 처리하는데 이 과정을 말함.
 * 동작 중인 프로세스가 대기하면서 해당 프로세스 상태(context)를 보관하고,
 * 대기하고 있던 다음 순서의 프로세스가 동작하면서 이전에 보관했던 프로세스의 상태를 복구하는 작업.
 * ---------------------------------------------------------------
 *
 */

/**
 * int numOfCores = Runtime.getRuntime().availableProcessors(); // 본인 컴퓨터 코어(논리 프로세서)개수 찾는 로직.
 *  System.out.println(numOfCores); 12
 */

public class 스트림_속도차이01 {
    public static void main(String[] args) {

//        final int[] sum = {0};
//        IntStream.range(0, 1000)
//                .forEach(i -> sum[0] += i); // single Thread
//        System.out.println(" stream sum = " + sum[0]); //  4950
////-----------------
//        final int[] sum2 = {0};
//        IntStream.range(0, 1000)
//                .parallel() // Multi  process 를 활용하여 여러 개의 스레드가 동시에 sum2의 상태를 바꾸는 것
//                .forEach(i -> sum2[0] += i);
//        System.out.println(" parallel sum = " + sum2[0]); // 2 4950
////--------------------------------
//        System.out.println("Stream sum = " + IntStream.range(0, 1000)
//                .sum()); // 3 4950
////--------------------------------
//        System.out.println("parallel stream sum = " + IntStream.range(0, 1000)
//                .parallel()
//                .sum()); // 4 4950
////-------------------------------
        System.out.println("------Stream------");

//        final long start = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) // 1초 당 하나씩 뽑아냄.
//                .stream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    ;
//                    return i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis() - start); // Millis 단위라 천 단위로 나옴. 예상 출력안 -> 13XXX

        System.out.println("------parallel Stream ( 12 elements )------");

        final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) // 12
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ;
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start2); // Millis 단위라 천 단위로 나옴. 예상 출력안 -> 1XXX


        System.out.println("------parallel Stream ( 13 elements )------");

//        final long start3 = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) // 12
//                .parallelStream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    ;
//                    return i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis() - start3); //

//        System.out.println("------parallel Stream ( 12 elements ) with parallelism : 11 ------");
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "11"); // 0이라면 single core, 1이라면 2 core, 2라면 3 core... 본인 6코어인데 논프 12이니 11 박을 예정
//        final long start4 = System.currentTimeMillis();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
//                .parallelStream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    ;
//                    return i;
//                })
//                .forEach(i -> System.out.println(i));
//        System.out.println(System.currentTimeMillis() - start4); // Millis 단위라 천 단위로 나옴. 예상 출력안 -> 1XXX



        System.out.println("------parallel Stream ( 12 elements ) with parallelism : 5 ------");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5"); // 코어 수를 반으로 제한
        final long start5 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ;
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start5); //
    }
}
