package array;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.print(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        /*
         * 需要考虑两点，一点是三个值加起来等于0，第二点是不能有重复的。
         * 加起来等于0，可以考虑使用 x + y = z来实现，
         * 去重可以先把数组进行排序，如果相同的值已经处理过了就不用再处理了
         */
        Arrays.sort(nums);
        List<List<Integer>> threeSums = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = i + 1;
            int m = nums.length - 1;
            int target = -nums[i];
            while (k < m) {
                if (nums[k] + nums[m] == target) {
                    List<Integer> threeSum = new ArrayList<>(3);
                    threeSum.add(nums[i]);
                    threeSum.add(nums[k]);
                    threeSum.add(nums[m]);
                    threeSums.add(threeSum);

                    while (k < nums.length - 2 && nums[k + 1] == nums[k]) {
                        k++;
                    }
                    while (m >0 && nums[m - 1] == nums[m]) {
                        m--;
                    }
                    k++;
                    m--;
                } else if (nums[k] + nums[m] > target) {
                    m--;
                } else {
                    k++;
                }
            }
        }

        return threeSums;
    }
}
