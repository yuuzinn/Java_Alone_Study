package javaOfGod.version1.Kevin_Stream;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples01 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> System.out.print(i + " "));

        IntStream.iterate(1, i -> i + 1)
                .forEach(i -> System.out.println(i + " "));

        //  iterate(seed, IntUnaryOperator)...
        //  seed ? 시작값, IntUnaryOperator(FunctionalInterface) ? int 를 받아서 int return

        Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
                .forEach(i -> System.out.println(i + " "));
    }
}
