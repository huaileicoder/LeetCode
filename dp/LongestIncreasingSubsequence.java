package leetcode.LeetCode.dp;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(arr, arr.length));
    }

    /**
     * dp time complexity O(n^2)
     */
    private static int lis(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = 1;
        for (int m : lis) {
            if (m > max) {
                max = m;
            }
        }
        return max;
    }
}
