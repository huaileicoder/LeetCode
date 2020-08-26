package leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    // solution 1
    public static int lengthOfLongestSubstring1(String s) {
        if (null == s) {
            return 0;
        }
        int length = s.length();
        if (length <= 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < length && rightIndex < length) {
            if (!set.contains(s.charAt(rightIndex))) {
                set.add(s.charAt(rightIndex++));
                maxLength = Math.max(maxLength, rightIndex - leftIndex);
            } else {
                set.remove(s.charAt(leftIndex++));
            }
        }
        return maxLength;
    }

    // solution 2
    public static int lengthOfLongestSubstring2(String s) {
        if (null == s) {
            return 0;
        }
        int length = s.length();
        if (length <= 0) {
            return 0;
        }
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }
}
