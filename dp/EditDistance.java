package leetcode.LeetCode.dp;

public class EditDistance {
    public static void main(String[] args) {
        String x = "sunday";
        String y = "saturday";
        System.out.println(moe(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
    }

    /**
     * convert to lcs
     * time complexity equip to lcs
     */
    private static int moe(char[] x, char[] y, int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        return m > n ? m - lcs(x, y, m, n) : n - lcs(x, y, m, n);
    }

    private static int lcs(char[] x, char[] y, int m, int n) {
        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }
}
