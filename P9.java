import java.util.*;
import java.math.*;

public class P9 {
    public static void main(String[] args) {
        long value, start, finish;
        start = System.nanoTime();
        int[] p9 = spt();
        System.out.println("/* Problem 9 */");
        System.out.printf("Answer: %s\n", p9[0] * p9[1] * p9[2]);
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 9: Special Pythagorean triplet */
    public static int[] spt() {
        int[] result = new int[3];
        for (int a = 1; a < 1000; a += 1) {
            for (int b = 1; b < 1000; b += 1) {
                double c = Math.sqrt(a * a + b * b);
                if (Math.floor(c) == c && (int) a + b + c == 1000) {
                    result[0] = a;
                    result[1] = b;
                    result[2] = (int) c;
                    return result;
                }
            }
        }
        return null;
    }
}