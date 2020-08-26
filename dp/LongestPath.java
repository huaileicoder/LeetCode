package leetcode.dp;

public class LongestPath {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 },
                        { 6, 5, 4 },
                        { 7, 8, 9 } };
        System.out.println(longestPath(arr));
    }

    private static int longestPath(int[][] arr) {
        int[][] path = new int[arr.length][arr.length];
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (path[i][j] > 0) {
                    continue;
                }
                findLongestPathFromCell(arr, path, i, j);
                result = Math.max(result, path[i][j]);
            }
        }
        return result;
    }

    private static int findLongestPathFromCell(int[][] arr, int[][] path, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            return 0;
        }
        if (path[i][j] > 0) {
            return path[i][j];
        }
        int result = 1;
        if (i + 1 < arr.length && arr[i][j] - arr[i + 1][j] == 1) {
            result = Math.max(result, findLongestPathFromCell(arr, path, i + 1, j) + 1);
        }
        if (j + 1 < arr.length && arr[i][j] - arr[i][j + 1] == 1) {
            result = Math.max(result, findLongestPathFromCell(arr, path, i, j + 1) + 1);
        }
        if (i - 1 >= 0 && arr[i][j] - arr[i - 1][j] == 1) {
            result = Math.max(result, findLongestPathFromCell(arr, path, i - 1, j) + 1);
        }
        if (j - 1 >= 0 && arr[i][j] - arr[i][j - 1] == 1) {
            result = Math.max(result, findLongestPathFromCell(arr, path, i, j - 1) + 1);
        }

        return path[i][j] = result;
    }
}
