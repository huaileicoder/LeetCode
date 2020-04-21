package leetcode.LeetCode.dp;

public class Partition {
    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 2, 2,1};
        System.err.println(findPartition(arr, arr.length));
    }

    private static boolean findPartition(int[] arr, int n) {
        if (n <= 1) {
            return false;
        }
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum <= 0 || sum % 2 != 0) {
            return false;
        }
        boolean[][] part = new boolean[sum / 2 + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            part[0][i] = true;
        }
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= arr[j - 1]) {
                    part[i][j] = part[i - arr[j - 1]][j - 1] || part[i][j - 1];
                } else {
                    part[i][j] = part[i][j - 1];
                }
            }
        }
        return part[sum / 2][n];
    }

}
