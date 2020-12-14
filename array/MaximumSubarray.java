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
        int midMaxSum = sum;
        int leftMaxSum = 0;
        int rightMaxSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int mLeftSum = sum - nums[rightIndex];
            int mRightSum = sum - nums[leftIndex];
            if (mLeftSum >= mRightSum) {
                rightSum += nums[rightIndex];
                rightMaxSum = Math.max(rightMaxSum, rightSum);
                rightIndex--;
            } else {
                leftSum += nums[leftIndex];
                leftMaxSum = Math.max(leftMaxSum, leftSum);
                leftIndex++;
            }
            sum = Math.max(mLeftSum, mRightSum);
            midMaxSum = Math.max(midMaxSum, sum);
            System.out.println("maxSum=" + midMaxSum + ", sum=" + sum + ", leftIndex=" + leftIndex + ", rightIndex=" + rightIndex +
                    ", leftMaxSum" + leftMaxSum + ", rightMaxSum=" + rightMaxSum);
        }
        return Math.max(Math.max(leftMaxSum, midMaxSum), rightMaxSum);
    }
}
