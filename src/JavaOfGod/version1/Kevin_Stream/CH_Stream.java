package JavaOfGod.version1.Kevin_Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class CH_Stream {
    public static void main(String[] args) {
        /**
         * 스트림은 한 번만 사용할 수 있습니다.
         * 스트림을 사용하거나 닫으면 다시 사용할 수 없습니다.
         * 따라서 스트림에 대해 수행해야 하는 모든 작업을 완료한 후에만 스트림을 사용해야 합니다.
         * 예를 들어, 다음 코드는 동일한 스트림이 여러 번 사용되기 때문에 예외를 발생시킵니다
         */
        List<Integer> numbers01 = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> stream = numbers01.stream();

        stream.forEach(System.out::println);
//        stream.forEach(System.out::println); // exception


        /**
         * 스트림을 올바르게 사용하지 않으면 성능 문제가 발생할 수 있습니다.
         * 스트림은 느리게 평가되기 때문에 전체 스트림을 평가하는 작업을 수행하는 데 시간이 걸릴 수 있습니다.
         * reduce 또는 collect 과 같은 비용이 많이 드는 작업을 수행하기 전에 필터 및 맵과 같은 작업을 사용해야 합니다.
         * 예를 들어, 다음 코드는 reduce 호출하기 전에 큰 스트림을 필터링하기 때문에 실행하는 데 시간이 오래 걸립니다:
         */
        List<Integer> numbers02 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers02.add(i);
        }

        long sum = numbers02.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println(sum);

        /**
         * 스트림으로 인해 리소스가 누출될 수 있습니다.
         * 스트림이 제대로 닫히지 않으면 리소스 누수가 발생하여 메모리 누수 또는 파일 핸들이 열린 상태로 유지되는 등의 문제가 발생할 수 있습니다.
         * 사용 후에는 항상 close() 메서드를 호출하거나 try-with-resources 문을 사용하여 스트림을 닫으십시오.
         * 예를 들어, 다음 코드는 스트림을 사용하여 파일을 읽고 try-with-resources 문을 사용하여 스트림을 닫도록 합니다:
         */
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            long count = lines.count();
            System.out.println("Number of lines: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 병렬 처리에 주의하십시오.
         * 병렬 스트림으로 작업할 때는 코드가 스레드 세이프인지 확인하고 동시성과 함께 추가되는 복잡성에 주의하십시오.
         * 또한 병렬 스트림이 항상 성능 향상으로 이어지는 것은 아니므로 코드를 벤치마킹하여
         * 병렬 처리가 실제로 이점을 제공하는지 확인하는 것이 중요합니다.
         * 예를 들어, 다음 코드는 병렬 스트림을 사용하여 큰 정수 목록의 합을 계산합니다:
         */

        List<Integer> numbers03 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers03.add(i);
        }

        long sum03 = numbers03.parallelStream().mapToLong(x -> x).sum();

        System.out.println(sum03);


        /**
         * 스트림은 기본 데이터 구조를 수정할 수 없습니다.
         * 스트림은 컬렉션에서 읽기 전용 작업을 수행하도록 설계되었습니다.
         * 기본 컬렉션을 수정해야 하는 경우 기존 루프를 대신 사용해야 합니다.
         * 예를 들어, 다음 코드는 스트림을 사용하여 목록을 반복하는 동안 목록을 수정하려고 시도합니다.
         * 이 경우 ConcurrentModification이 느려집니다예외:
         */

        List<Integer> numbers04 = new ArrayList<>();
        numbers04.add(1);
        numbers04.add(2);
        numbers04.add(3);

        numbers04.stream().forEach(number -> numbers04.add(number * 2)); //  exception


        /**
         * 작은 컬렉션에는 스트림을 사용하지 마십시오.
         * 스트림을 설정하고 처리하는 데 드는 오버헤드는 매우 작은 컬렉션에 스트림을 사용하는 것의 이점을 능가할 수 있습니다.
         * 일반적으로 요소가 100개 미만인 컬렉션에는 기존 루프를 사용하는 것이 좋습니다.
         * 예를 들어, 다음 코드는 전통적인 루프를 사용하여 작은 정수 목록의 합을 계산한다:
         */
        
    }
}
