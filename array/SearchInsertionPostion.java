package array;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertionPostion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 9, 11, 14};
        System.out.print(searchInsert(nums, 19));
    }

    private static int searchInsert(int[] nums, int target) {
        // solution 1 iteration
        /*for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }*/

        // solution 2 binary search but time limit exceeded
        /*int midIndex = nums.length / 2;
        while (midIndex > 0 || midIndex < nums.length) {
            if (target == nums[midIndex]) {
                return midIndex;
            }
            if (target < nums[midIndex]) {
                if (midIndex <= 0 || target > nums[midIndex - 1]) {
                    return midIndex;
                }
                if (target == nums[midIndex - 1]) {
                    return midIndex - 1;
                }
                midIndex /= 2;
                if (midIndex <= 0) {
                    return 0;
                }
            }
            if (target > nums[midIndex]) {
                if (midIndex >= nums.length - 1 || target <= nums[midIndex + 1]) {
                    return midIndex + 1;
                }
                midIndex = (midIndex + nums.length) / 2;
            }
        }*/

        // solution 3 the truly binary search
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (target == nums[midIndex]) {
                return midIndex;
            }
            if (target < nums[midIndex]) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }
        return lowIndex;
    }
}
