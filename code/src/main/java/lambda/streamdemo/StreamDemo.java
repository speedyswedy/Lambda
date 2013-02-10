package lambda.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.streams.Streams;

public class StreamDemo {
    public static void main (String[] args) {
        int max = Runtime.getRuntime().availableProcessors();
        System.out.format("Checking numbers [1..%d]...%n", max);
        long start = System.nanoTime();
        System.out.format("Odd numbers: %s%n", naturalNumbersUpTo(max).stream().filter(StreamDemo::heavyIsOdd).into(new ArrayList<Integer>()));
        long end = System.nanoTime();
        System.out.format("Time taken: %f%n", (end - start) /1.0e9);
        start = System.nanoTime();
        System.out.format("Odd numbers: %s%n", naturalNumbersUpTo(max).parallel().filter(StreamDemo::heavyIsOdd).into(new ArrayList<Integer>()));
        end = System.nanoTime();
        System.out.format("Time taken: %f%n", (end - start) /1.0e9);
    }

    public static List<Integer> naturalNumbersUpTo(int max) {
        return Streams.iterate(1, num -> num + 1).limit(max).into(new ArrayList<Integer>(max));
    }

    public static boolean heavyIsOdd(Integer number) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return number % 2 == 1;
    }

}
