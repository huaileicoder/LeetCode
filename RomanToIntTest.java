package leetcode.LeetCode;

public class RomanToIntTest {
    public static void main(String[] args) {
        String roman = "MCDLXXVI";
        System.out.println(romanToInt(roman));
    }

    public static int romanToInt(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        int result = 0;
        for (int index = 0; index < s.length(); index = index + 2) {
            int left = getValueByRoman(chars[index]);
            if (index == s.length() - 1) {
                result += left;
                return result;
            }
            int right1 = getValueByRoman(chars[index + 1]);
            if (left < right1) {
                result += right1 - left;
                continue;
            } else {
                if (index == s.length() - 2) {
                    result += left + right1;
                    return result;
                }
            }
            int right2 = getValueByRoman(chars[index + 2]);
            if (right1 < right2) {
                result += left + right2 - right1;
                index++;
                continue;
            }
            result += left + right1;
        }
        return result;
    }

    public static int getValueByRoman(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
