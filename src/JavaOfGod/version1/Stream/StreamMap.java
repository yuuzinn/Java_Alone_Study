package JavaOfGod.version1.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

//        for (int i = 1; i < list.size() + 1; i++) {
//            System.out.println(i * 3);
//        }
//        System.out.println("-------");
//
//        for (Integer i : list) {
//            System.out.println(i * 3);
//        }

        System.out.println("-------");

//        list.stream().forEach(value -> System.out.println(value * 3));
        list.stream().map(x -> x * 3).forEach(System.out::println);
    }
}
