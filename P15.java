import java.util.*;
import java.math.*;
import java.io.*;

public class P15 {
    public static void main(String[] args) throws IOException {
        long start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 15 */");
        System.out.printf("Answer: %s\n", lp(20));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 15: Lattice Paths */
    public static long lp(int num) {
        assert num >= 0;
        long[][] mem = new long[num + 1][num + 1];
        mem[0][0] = 1;
        return lpHelper(mem, num, num);        
    }

    public static long lpHelper(long[][] mem, int i, int j) {
        if (mem[i][j] != 0) return mem[i][j];
        long result = 0;
        if (i > 0) result += lpHelper(mem, i - 1, j);
        if (j > 0) result += lpHelper(mem, i, j - 1);
        mem[i][j] = result;
        return result;
    }

}
