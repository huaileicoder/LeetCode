package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    private static Map<Integer, Map<Integer, Integer>> i2J2Lcs = new HashMap<>();

    public static void main(String[] args) {
        String s = "aabcdd";
        String t = "aabd";
        System.out.println(lcs3(s.toCharArray(), t.toCharArray(), s.length(), t.length()));
    }

    /**
     * 递归
     */
    private static int lcs(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return 0;
        }
        if (s.equals(t)) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int i = chars.length - 1;
        int j = chart.length - 1;
        Map<Integer, Integer> j2Lcs = i2J2Lcs.get(i);
        if (null == j2Lcs) {
            j2Lcs = new HashMap<>(chart.length);
            i2J2Lcs.putIfAbsent(i, j2Lcs);
        }
        Integer lcs = j2Lcs.get(j);
        if (null != lcs) {
            return lcs;
        }
        if (chars[i] == chart[j]) {
            lcs = lcs(s.substring(0, i), t.substring(0, j)) + 1;
        } else {
            int result1 = lcs(s, t.substring(0, j));
            int result2 = lcs(s.substring(0, i), t);
            lcs = Math.max(result1, result2);
        }
        j2Lcs.putIfAbsent(j, lcs);

        return lcs;
    }

    private static int recursiveLcs(char[] x, char[] y, int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (x[m] == y[n]) {
            return recursiveLcs(x, y, m - 1, n - 1) + 1;
        } else {
            return Math.max(recursiveLcs(x, y, m - 1, n), recursiveLcs(x, y, m, n - 1));
        }
    }

    /**
     * BOTTOM_TO_UP
     */
    private static int lcs2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int lcs = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chart.length; j++) {
                Map<Integer, Integer> j2Lcs = i2J2Lcs.computeIfAbsent(i, jMap -> new HashMap<>(chart.length));
                if (chars[i] == chart[j]) {
                    if (i > 0 && j > 0) {
                        lcs = i2J2Lcs.get(i - 1).get(j - 1) + 1;
                    } else {
                        lcs = 1;
                    }
                } else {
                    int lcs1 = 0;
                    if (i > 0) {
                        lcs1 = i2J2Lcs.get(i - 1).get(j);
                    }
                    int lcs2 = 0;
                    if (j > 0) {
                        lcs2 = i2J2Lcs.get(i).get(j - 1);
                    }
                    lcs = Math.max(lcs1, lcs2);
                }
                j2Lcs.putIfAbsent(j, lcs);
                System.out.println("i = " + i + " ,j = " + j + " ,lcs = " + lcs);
            }
        }
        return lcs;
    }

    /**
     * array implementation
     */
    private static int lcs3(char[] x, char[] y, int m, int n) {
        int[][] l = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                    continue;
                }
                if (x[i - 1] == y[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i][j - 1], l[i - 1][j]);
                }
            }
        }
        return l[m][n];
    }

    private static void printLcs(String s, String t, int lcsLength) {
        int m = s.length();
        int n = t.length();
        int temp = lcsLength;
        char[] lcs = new char[lcsLength + 1];
        lcs[temp] = ' ';
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                lcs[temp - 1] = s.charAt(i - 1);
                i--;
                j--;
                temp--;
            } else {
                //if ()

            }
        }
    }

}
