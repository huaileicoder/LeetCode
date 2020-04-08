package leetcode.LeetCode;

public class MaximumAmount {
    public static void main(String[] args) {
        int[] arr = { 20, 30, 2, 2, 2, 10 };
        System.out.println(findMax(arr));
    }

    /**
     * F(i,j)=Max(vi + min(F(i+1,j-1), F(i+2,j)), vj + min(F(i,j-2), F(i+1, j-1)))
     * Base case
     * F(i,j)=vi if i == j;
     * F(i,j)=Max(vi, vj) if j= i + 1;
     */
    private static int findMax(int[] arr) {
        int x;
        int y;
        int z;
        int[][] result = new int[arr.length][arr.length];
        for (int m = 0; m < arr.length; m++) {
            for (int i = 0, j = m; j < arr.length; j++, i++) {
                x = (i + 2) <= j ? result[i + 2][j] : 0;
                y = (i + 1) <= (j - 1) ? result[i + 1][j - 1] : 0;
                z = i <= (j - 2) ? result[i][j - 2] : 0;
                result[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return result[0][arr.length - 1];
    }
}
