package leetcode;

import java.util.*;
import java.util.function.BiFunction;

public class AnagramTest {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    //private static boolean isAnagram(String s, String t) {
    //    if (null == s || null == t || s.length() != t.length()) {
    //        return false;
    //    }
    //    Map<Integer, Character> map1 = new TreeMap<>();
    //    Map<Integer, Character> map2 = new TreeMap<>();
    //    putToMap(s, map1);
    //    putToMap(t, map2);
    //    return map1.equals(map2);
    //}
    //
    //private static void putToMap(String s, Map<Integer, Character> map) {
    //    char[] chars = s.toCharArray();
    //    Arrays.sort(chars);
    //    int index = 0;
    //    for (char c : chars) {
    //        map.put(index, c);
    //        index++;
    //    }
    //}

    private static boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character, Integer> characters1 = new HashMap<>(chars1.length);
        Map<Character, Integer> characters2 = new HashMap<>(chars2.length);
        BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        for (char c : chars1) {
            characters1.merge(c, 1, biFunction);
        }
        for (char c : chars2) {
            characters2.merge(c, 1, biFunction);
        }
        if (characters1.size() != characters2.size()) {
            return false;
        }

        return characters1.equals(characters2);
    }

}
