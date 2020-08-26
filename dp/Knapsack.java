package leetcode.LeetCode.dp;

/**
 * 背包
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int capacity = 50;
        System.out.println(findMax(val, wt, capacity));
    }

    private static int findMax(int[] val, int[] wt, int capacity) {
        int[][] result = new int[val.length + 1][capacity + 1];
        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (wt[i - 1] <= j) {
                    result[i][j] = Math.max(val[i - 1] + result[i - 1][j - wt[i - 1]], result[i - 1][j]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[val.length][capacity];
    }
}
