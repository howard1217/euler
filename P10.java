import java.util.*;
import java.math.*;

public class P10 {
    public static void main(String[] args) {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 10 */");
        System.out.printf("Answer: %s\n", sop(2000000));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 10: Summation of primes */
    public static long sop(int range) {
        long result = 0;
        for (int i = 2; i <= range; i += 1) {
            if (isPrime(i)) result += i;
        }
        return result;
    }

    public static boolean isPrime(int num) {
        assert num > 1;
        if (primes.contains(num)) return true;
        if (num == 2) {
            primes.add(2);
            return true;
        }
        double limit = Math.sqrt(num);
        for (int i = 2; (double) i <= limit; i += 1) {
            if (isPrime(i) && num % i == 0) return false;
        }
        primes.add(num);
        return true;
    }

    static Set<Integer> primes = new HashSet<Integer>();
}