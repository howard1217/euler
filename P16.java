import java.util.*;
import java.math.*;
import java.io.*;

public class P16 {
    public static void main(String[] args) throws IOException {
        long start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 16 */");
        System.out.printf("Answer: %s\n", pds(1000));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 16: Power Digit Sum */
    public static long pds(int num) {
        assert num >= 0;
        LinkedList<Integer> pow = new LinkedList<Integer>();
        pow.add(1);
        for (int i = 0; i < num; i += 1) {
            LinkedList<Integer> newPow = new LinkedList<Integer>();
            int last = 0;
            while (pow.size() > 0) {
                int product = pow.remove() * 2;
                newPow.add(product % 10 + last);
                last = product / 10;
                if (pow.size() == 0 && product > 9) pow.add(0);
            }
            pow = newPow;
        }
        long result = 0;
        while (pow.size() > 0) result += pow.remove();
        return result;
    }

}
