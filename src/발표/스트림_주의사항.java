package 발표;

/**
 * stream 주의사항 10가지 ?
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class 스트림_주의사항 {
    public static void main(String[] args) {
//        System.out.println("----------1----------");
//        IntStream stream = IntStream.of(1, 2);
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);

        System.out.println("------------");

//        ArrayList<Integer> list01 = new ArrayList<Integer>();
//        list01.add(4);
//        list01.add(2);
//        list01.add(3);
//        list01.add(1);
//        Stream<Integer> stream01 = list01.stream();
//        stream01.forEach(System.out::println);
//        stream01.forEach(System.out::println);

        System.out.println("----------2----------");
//        IntStream.iterate(0, i -> i + 1)
//                .forEach(System.out::println);

        System.out.println("-----------");

//        IntStream.iterate(0, i -> i + 1)
//                .limit(10)
//                .forEach(System.out::println);
//0 1 0 1 0 1 0 1 0 1 complete
        System.out.println("----------3_2----------");
//        IntStream.iterate(0, i -> ( i + 1 ) % 2)
//                .distinct()
//                .limit(10)
//                .forEach(System.out::println);
//        System.out.println("complete");
//


        System.out.println("----------4----------");
//
//        IntStream.iterate(0, i -> ( i + 1 ) % 2)
//                .limit(10)
//                .distinct()
//                .forEach(System.out::println);
//        System.out.println("complete");
//
//        System.out.println("----------5----------");


//        IntStream.iterate(0, i -> (i + 1) % 2)
//                .parallel() // point
//                .distinct()
//                .limit(10)
//                .forEach(System.out::println);

        System.out.println("----------5----------");
//
//        List<Integer> list02 =
//                IntStream.range(0, 10) //
//                        .boxed() //
//                        .collect(toCollection(ArrayList::new)); //
//
//        list02.stream()
//                .peek(list02::remove) //
//                .forEach(System.out::println); //


//        list02.stream()
//                .sorted()
//                .peek(list02::remove)
//                .forEach(System.out::println); //
//
//        list02.stream()
//                .sorted()
//                .parallel() //
//                .peek(list02::remove)
//                .forEach(System.out::println);

//        List<Integer> listTest = new ArrayList<>();
//        listTest.add(1);
//        for (int a : listTest) {
//            listTest.add(1);
//            System.out.println(a);
//        }

        System.out.println("----------6----------");

        List<Integer> numbers04 = new ArrayList<>();
        numbers04.add(1);
        numbers04.add(2);
        numbers04.add(3);

        numbers04.stream().forEach(number -> numbers04.add(number * 2));

    }

}
