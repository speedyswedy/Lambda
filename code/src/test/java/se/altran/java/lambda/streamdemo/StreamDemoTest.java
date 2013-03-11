package se.altran.java.lambda.streamdemo;

import org.junit.Test;
import se.altran.java.lambda.streamdemo.StreamDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StreamDemoTest {
    @Test
    public void naturalNumbersUpToReturnsAListFromOneToTheSuppliedNumber() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = StreamDemo.naturalNumbersUpTo(6);
        assertEquals(expected, actual);
    }

    @Test
    public void naturalNumbersUpToReturnsAnEmptyListForZero() {
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = StreamDemo.naturalNumbersUpTo(0);
        assertEquals(expected, actual);
    }
}
