package leetcode.LeetCode;

import java.util.*;

public class AnagramTest {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character, Integer> characters1 = new HashMap<>();
        Map<Character, Integer> characters2 = new HashMap<>();
        for (char c : chars1) {
            Integer oldNum = characters1.get(c);
            if (null == oldNum) {
                characters1.put(c, 1);
            } else {
                characters1.put(c, oldNum + 1);
            }
        }
        for (char c : chars2) {
            Integer oldNum = characters2.get(c);
            if (null == oldNum) {
                characters2.put(c, 1);
            } else {
                characters2.put(c, oldNum + 1);
            }
        }

        if (characters1.size() != characters2.size()) {
            return false;
        }

        return isEquals(characters1, characters2);
    }

    private static boolean isEquals(Map<Character, Integer> c1, Map<Character, Integer> c2) {
        for (Map.Entry<Character, Integer> entry : c1.entrySet()) {
            Character character = entry.getKey();
            Integer c2Num = c2.get(character);
            if (null == c2Num || !c2Num.equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
