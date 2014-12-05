import java.util.*;
import java.math.*;
import java.io.*;

public class P18 {
    public static void main(String[] args) throws IOException {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 18 */");
        System.out.printf("Answer: %s\n", mps("P18.txt", 15));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 18: Maximum path sum I */
    public static long mps(String path, int level) throws IOException {
        System.setIn(new FileInputStream(new File(path)));
        int[][] tri = new int[level][level];
        for (int i = 0; i < level; i++) {
            for (int j = 0; j <= i; j++) {
                int ch;
                int num = 0;
                while ((ch = System.in.read()) >= '0' && ch <= '9') {
                    num *= 10;
                    num += ch - '0';
                }
                tri[i][j] = num;
            }
        }
        System.in.close();
        ArrayList<Integer> sum = new ArrayList<Integer>();
        sum.add(tri[0][0]);
        for (int i = 1; i < level; i++) {
            ArrayList<Integer> next = new ArrayList<Integer>();
            for (int j = 0; j <= i; j += 1) {
                int curr;
                if (j == i) curr = sum.get(j - 1);
                else if (j == 0) curr = sum.get(0);
                else curr = Math.max(sum.get(j - 1), sum.get(j));
                next.add(curr + tri[i][j]);
            } 
            sum = next;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < level; i += 1) result = Math.max(result, sum.get(i));
        return result;
    }
}
