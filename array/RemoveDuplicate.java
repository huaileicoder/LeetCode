package array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @author lei.huai
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int newArraySize = nums.length;
        int duplicateIndex = -1;
        int leftIndex = 0;
        int rightIndex = 1;
        int duplicateNum = 0;
        while (rightIndex < nums.length) {
            if (nums[rightIndex] == nums[leftIndex]) {
                newArraySize--;
                duplicateNum++;
                if (duplicateNum <= 1) {
                    duplicateIndex = rightIndex;
                }
                rightIndex++;
            } else {
                if (duplicateIndex > -1) {
                    nums[duplicateIndex++] = nums[rightIndex];
                }
                leftIndex++;
                rightIndex++;
            }
        }

        print(newArraySize, nums);

        return newArraySize;
    }

    private static void print(int size, int[] nums) {
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


}
