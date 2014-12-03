import java.util.*;
import java.math.*;
import java.io.*;

public class P14 {
    public static void main(String[] args) throws IOException {
        long start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 14 */");
        System.out.printf("Answer: %s\n", lcs(1000000));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 14: Longest Collatz sequence */
    public static int lcs(int num) {
        assert num >= 0;
        int longest = 0;
        int result = 0;
        for (int i = 1; i < num; i += 1) {
            int len = runCS(i);
            if (len > longest) {
                longest = len;
                result = i;
            }
        }
        return result;
    }

    /** Run the Collatz Sequence from N and return the length. */
    public static int runCS(int n) {
        assert n >= 0;
        int result = 0;
        long k = n;
        while (k > 1) {
            if (lenMap.containsKey(k)) {
                result += lenMap.get(k);
                break;
            }
            if (k % 2 == 0) k /= 2;
            else k = 3 * k + 1;
            result += 1;
        }
        lenMap.put((long) n, result);
        return result;
    }

    public static Map<Long, Integer> lenMap = new HashMap<Long, Integer>();
}
