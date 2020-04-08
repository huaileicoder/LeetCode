package leetcode.LeetCode.dp;

public class CountOfCoverDistance {
    public static void main(String[] args) {
        System.out.println(count(6));
    }

    private static int count(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                count[i] = 1;
            }
            for (int j = 1; j <= 3; j++) {
                if (i >= j) {
                    count[i] += count[i - j];
                }
            }
        }
        return count[n];
    }
}
