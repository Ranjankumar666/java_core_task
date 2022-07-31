package src.question4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Question4Test  {
    protected Question4 testClass = new Question4();

    @Test
    public void checkMax() {
        int[] vals = { 1, 2, 5, 6, 8 };
        int expected = Arrays.stream(vals).max().getAsInt();

        assertEquals(expected, testClass.getMax(vals));
    }

    @Test
    public void checkNthFibo() {
        int n = 7;
        int expected = 8;
        assertEquals(expected, testClass.getFibonacci(n));
    }
}
