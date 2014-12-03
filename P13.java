import java.util.*;
import java.math.*;
import java.io.*;

public class P13 {
    public static void main(String[] args) throws IOException {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 13 */");
        System.out.printf("Answer: %s\n", lg("P13.txt", 50, 100));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 13: Large sum */
    public static long lg(String path, int width, int height) throws IOException {
        System.setIn(new FileInputStream(new File(path)));
        int[][] nums = new int[height][width];
        for (int i = 0; i < height; i += 1) {
            for (int j = 0; j < width; j += 1) {
                nums[i][j] = (int) System.in.read() - '0';
            }
            System.in.read();
        }
        System.in.close();
        return addNums(nums, width, height);
    }

    public static long addNums(int[][] nums, int width, int height) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int j = width - 1; j >= 0; j -= 1) {
            int curr = 0;
            for (int i = 0; i < height; i += 1) curr += nums[i][j];
            stack.push(curr % 10);
            if (j == 0) {
                char[] digits = Integer.toString(curr / 10).toCharArray();
                for (int k = digits.length - 1; k >= 0; k -= 1) {
                    stack.push((int) digits[k] - '0');
                }
            } else nums[0][j - 1] += curr / 10;
        }
        long result = 0;
        for (int i = 0; i < 10; i += 1) {
            result *= 10;
            result += stack.pop();
        }
        return result;
    }

}
