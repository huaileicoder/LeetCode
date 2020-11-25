package array;

import utils.PrintUtil;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3};
        System.out.println(removeElement(nums, 2));
    }

    private static int removeElement(int[] nums, int val) {
        int newArraySize = nums.length;
        int curIndex = 0;
        int rmvIndex = -1;
        while (curIndex < nums.length) {
            if (nums[curIndex] == val) {
                if (rmvIndex < 0) {
                    rmvIndex = curIndex;
                }
                newArraySize--;
            } else {
                if (rmvIndex > -1) {
                    int tmp = nums[rmvIndex];
                    nums[rmvIndex] = nums[curIndex];
                    nums[curIndex] = tmp;
                    rmvIndex++;
                }
            }
            curIndex++;
        }

        PrintUtil.printArray(nums, newArraySize);

        return newArraySize;
    }

}
