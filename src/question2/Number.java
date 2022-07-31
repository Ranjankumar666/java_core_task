package src.question2;

import java.util.HashSet;
import java.util.Stack;

public class Number {
    private double val;

    Number(double val) {
        this.val = val;
    }

    public boolean isZero() {
        return val == 0;
    }

    public boolean isNegative() {
        return val < 0;
    }

    public boolean isPositive() {
        return !isNegative();
    }

    public boolean isOdd() {
        return val % 2 != 0;
    }

    public boolean isEven() {
        return !isOdd();
    }

    public boolean isPrime() {
        if (isNegative())
            return false;

        if (val <= 1)
            return true;

        double sqrt = Math.sqrt(val);
        for (int i = 2; i <= sqrt; i++) {
            if (val % i == 0)
                return false;
        }

        return true;
    }

    public boolean isArmstrong() {
        double n = Math.ceil(Math.log10(val));
        double sum = 0;
        double num = val;

        while (num > 0) {
            sum += Math.pow((num % 10), n);
            num = Math.floor(num / 10);
        }

        return sum == val;
    }

    public double getFactorial() {
        double num = val;
        double res = 1;

        while (num != 0) {
            res *= num;
            num -= 1;

        }

        return res;
    }

    public double getSqr() {
        return val * val;
    }

    public double getSqrt() {
        return Math.sqrt(val);
    }

    public double sumDigits() {
        double sum = 0;
        double num = val;

        while (num > 0) {
            sum += (num % 10);
            num = Math.floor(num / 10);
        }

        return sum;
    }

    public double getReverse() {
        double n = Math.floor(Math.log10(val));
        double rev = 0;
        double num = val;
        double i = n;

        while (num > 0) {
            rev += (num % 10) * Math.pow(10, i);
            num = Math.floor(num / 10);
            i -= 1;
        }

        return rev;
    }

    public HashSet<Double> listFactor() {
        HashSet<Double> factors = new HashSet<>();
        double limit = Math.ceil(Math.sqrt(val));

        for (double i = 0; i <= limit; i++) {
            if (val % i == 0) {
                factors.add(i);

                if (val / i != i) {
                    factors.add(val / i);
                }

            }
        }

        return factors;
    }

    public String displayBinary() {
        Stack<Integer> stk = new Stack<>();
        double num = val;

        while (num > 0) {
            stk.push((int) num % 2);
            num = Math.floor(num / 2);
        }

        StringBuilder res = new StringBuilder();

        while (!stk.isEmpty()) {
            res.append(String.valueOf(stk.pop()));
        }

        return res.toString();
    }
}
