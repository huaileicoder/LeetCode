package leetcode.LeetCode.dp;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.err.println(isEqualToSum(arr, 100));
    }

    private static boolean isEqualToSum(int[] arr, int sum) {
        boolean[][] isEqual = new boolean[sum + 1][arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            isEqual[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= arr.length; j++) {
                isEqual[i][j] = isEqual[i][j - 1];
                if (i >= arr[j - 1]) {
                    isEqual[i][j] = isEqual[i - arr[j - 1]][j - 1] || isEqual[i][j - 1];
                }
            }
        }
        return isEqual[sum][arr.length - 1];
    }
}
