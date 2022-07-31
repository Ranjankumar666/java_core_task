package src.question4;

import java.util.HashMap;

public class Question4 {
    private int _getMax(int[] arr, int i, int j) {
        if (j - i == 1)
            return arr[i];

        return Math.max(arr[i], _getMax(arr, i + 1, j));
    }

    public int getMax(int[] arr) {
        return _getMax(arr, 0, arr.length);
    }

    private int _getFibonacci(int n, HashMap<Integer, Integer> dp) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        if (dp.containsKey(n))
            return dp.get(n);

        int val = _getFibonacci(n - 1, dp) + _getFibonacci(n - 2, dp);
        dp.put(n, val);

        return val;
    }

    public int getFibonacci(int n) {
        return _getFibonacci(n, new HashMap<>());
    }
}
