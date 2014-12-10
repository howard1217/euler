import java.util.*;
import java.math.*;
import java.io.*;
import java.util.regex.*;

public class P22 {
    public static void main(String[] args) throws IOException {
        long value, start, finish;
        start = System.nanoTime();
        System.out.println("/* Problem 22 */");
        System.out.printf("Answer: %s\n", ns("P22.txt"));
        finish = System.nanoTime();
        System.out.printf("Process Time = %s ms\n", (finish - start) / 1000000);
    }

    /* Problem 22: Names scores */
    public static long ns(String path) throws IOException {
        parse(path);
        long result = 0;
        int i = 1;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            int val = 0;
            for (int j = 0; j < s.length(); j++) {
                val += s.charAt(j) - 'A' + 1;
            }
            result += i * val;
            i++;
        }
        return result;
    }

    public static void parse(String path) throws IOException {
        Scanner sc = new Scanner(new File(path));
        Pattern pat = Pattern.compile(",");
        sc.useDelimiter(pat);
        while (sc.hasNext()) {
            String s = sc.next();
            queue.add(s.substring(1, s.length() - 1));
        }
        sc.close();
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int l1 = s1.length(), l2 = s2.length();
            for (int i = 0; i < Math.min(l1, l2); i++) {
                char c1 = s1.charAt(i), c2 = s2.charAt(i);
                if (c1 < c2) return -1;
                if (c1 > c2) return 1;
            }
            if (l1 < l2) return -1;
            if (l1 > l2) return 1;
            return 0;
        }
    }

    private static PriorityQueue<String> queue = new PriorityQueue<String>(10, new StringComparator());
}
