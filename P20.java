import java.util.*;
import java.math.*;
import java.io.*;

public class P20 {
    public static void main(String[] args) {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 20 */");
        System.out.printf("Answer: %s\n", fds(100));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 20: Factorial digit sum */
    public static long fds(int num) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        String s = fact.toString();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) - '0';
        }
        return result;
    }
}
