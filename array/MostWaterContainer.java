package array;

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
