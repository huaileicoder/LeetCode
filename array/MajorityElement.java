package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int leftIndex = 0;
        int maxLength = 0;
        int majorityElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (i - leftIndex > maxLength) {
                    maxLength = i - leftIndex;
                    leftIndex = i;
                    majorityElement = nums[i - 1];
                    if (maxLength > nums.length / 2) {
                        return majorityElement;
                    }
                } else {
                    leftIndex++;
                }
            }
        }
        majorityElement = nums.length - leftIndex > maxLength ? nums[nums.length - 1] : majorityElement;
        return majorityElement;
    }

    private static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer times = map.get(num);
            times = null == times ? 0 : times;
            map.put(num, times + 1);
        }
        int maxTimes = 0;
        int majorityElement = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxTimes) {
                maxTimes = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
}
