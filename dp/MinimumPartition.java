package leetcode.LeetCode.dp;

public class MinimumPartition {
    public static void main(String[] args) {
        int[] arr = {100, 1, 3, 45, 98};
        System.out.println(findMin(arr, arr.length));
    }

    private static int findMin(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return arr[0];
        }
        if (n <= 2) {
            return Math.abs(arr[0] - arr[1]);
        }
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum <= 0) {
            return 0;
        }
        boolean[][] part = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            part[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j >= arr[i - 1]) {
                    part[i][j] = part[i - 1][j - arr[i - 1]];
                } else {
                    part[i][j] = part[i - 1][j];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j > 0; j--) {
            if (part[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

}
