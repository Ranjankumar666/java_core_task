package src.question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class NumberTest {

    @Test
    public void checkIfZero() {
        Number num = new Number(0);
        assertTrue("Check if number is zero", num.isZero());
    }

    @Test
    public void checkIfArmstrong() {
        Number num = new Number(153);
        assertTrue("Check if number is Armstrong", num.isArmstrong() == true);
    }

    @Test
    public void checkIfPrime() {
        Number num = new Number(23);
        assertTrue("Check if number is prime", num.isPositive() == true);
    }

    @Test
    public void checkSumOfDigits() {
        Number num = new Number(1234);
        assertTrue("Check if the sum of digits of 1234 is 10", num.sumDigits() == 10);
    }

    @Test
    public void checkFactorial() {
        Number num = new Number(5);
        assertTrue("Check if the factorial is 120 for 5", num.getFactorial() == 120);
    }

    @Test
    public void checkReverse() {
        Number num = new Number(123);
        assertTrue("Check if the reverse for 123 is 321", num.getReverse() == 321);
    }

    @Test
    public void checkFactors() {
        Number num = new Number(24);
        Set<Double> factors = new HashSet<>();

        for (int val : new int[] { 1, 2, 3, 4, 6, 8, 12, 24 }) {
            factors.add((double) val);
        }

        assertEquals(factors, num.listFactor());
    }

    @Test
    public void checkBinary() {
        Number num = new Number(18);
        assertTrue("Check the binary", num.displayBinary().equals("10010"));
    }
}