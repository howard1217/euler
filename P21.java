import java.util.*;
import java.math.*;
import java.io.*;

public class P21 {
    public static void main(String[] args) {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 21 */");
        System.out.printf("Answer: %s\n", an(10000));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 21: Amicable Numbers */
    public static long an(int num) {
        assert num > 0;
        long result = 0;
        for (int i = 1; i < num; i++) {
            int temp = sumDivisors(i);
            if (isAmicable(i, temp) && !used.contains(i)) {
                used.add(i);
                used.add(temp);
                result += i;
                result += temp;
            }
        }
        return result;
    }

    public static int sumDivisors(int num) {
        assert num > 0;
        if (divSum.containsKey(num)) return divSum.get(num);
        int result = 0;
        double limit = Math.sqrt(num);
        for (int i = 1; i <= (int) Math.floor(limit); i++) {
            if (num % i == 0) {
                result += i;
                int quotient = num / i;
                if (quotient != i && quotient < num) result += quotient;
            }
        }
        divSum.put(num, result);
        return result;
    }

    public static boolean isAmicable(int n1, int n2) {
        assert n1 > 0 && n2 > 0;
        if (n1 == n2) return false;
        return sumDivisors(n1) == n2 && sumDivisors(n2) == n1;
    }

    public static Set<Integer> used = new HashSet<Integer>();
    public static Map<Integer, Integer> divSum = new HashMap<Integer, Integer>();
}
