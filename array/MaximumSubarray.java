package array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        int midSum = sum;
        int leftSum = 0;
        int rightSum = 0;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int mLeftSum = sum - nums[rightIndex];
            int mRightSum = sum - nums[leftIndex];
            if (mLeftSum >= mRightSum) {
                rightIndex--;
            } else {
                leftIndex++;
            }
            sum = Math.max(mLeftSum, mRightSum);
            midSum = Math.max(midSum, sum);
            System.out.println("maxSum=" + midSum + ", sum=" + sum + ", leftIndex=" + leftIndex + ", rightIndex=" + rightIndex);
        }
        return Math.max(Math.max(leftSum, midSum), rightSum );
    }
}
