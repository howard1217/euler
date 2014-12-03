import java.util.*;
import java.math.*;

public class P12 {
    public static void main(String[] args) {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 11 */");
        System.out.printf("Answer: %s\n", hdtn(500));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 12: Highly divisible triangular number */
    public static int hdtn(int num) {
        int curr = 1, div = 1, index = 1;
        while (div < num) {
            index += 1;
            curr += index;
            div = findDivisors(curr);
        }
        return curr;
    }

    public static int findDivisors(int n) {
        assert n >= 1;
        if (divisors.containsKey(n)) return divisors.get(n);
        int result = 0;
        double limit = Math.sqrt(n);
        for (int i = 1; (double) i <= limit; i += 1) {
            if (n % i == 0) result += 2;
        }
        if (Math.floor(limit) == limit) result -= 1;
        return result;

    }

    public static Map<Integer, Integer> divisors = new HashMap<Integer, Integer>();
}
