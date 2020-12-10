package array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines,
 * which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 */
public class MostWaterContainer {
    public static void main(String[] args) {
        int[] height = {2, 4, 5, 2, 4};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        // solution 1
        /*for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }*/

        // solution 2
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
