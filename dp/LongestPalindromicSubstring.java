package leetcode.LeetCode.dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    //public static String longestPalindrome(String s) {
    //    int length = s.length();
    //    if (length <= 1) {
    //        return s;
    //    }
    //    StringBuilder sb = new StringBuilder(s);
    //    String rs = sb.reverse().toString();
    //    if (rs.equals(s)) {
    //        return s;
    //    }
    //    String longestPalindrome = "";
    //    int left = 0;
    //    for (int index = 0; index < length; index++) {
    //        if (s.charAt(index) != rs.charAt(index)) {
    //            if (index - left < 1) {
    //                left++;
    //                continue;
    //            }
    //            String candidate = s.substring(left, index);
    //            if (checkPalindrome(candidate)) {
    //                if (candidate.length() > longestPalindrome.length()) {
    //                    longestPalindrome = candidate;
    //                }
    //            }
    //            left = index;
    //        }
    //    }
    //
    //    return "".equals(longestPalindrome) ? s.substring(0, 1) : longestPalindrome;
    //}

    //public static String longestPalindrome(String s) {
    //    int length = s.length();
    //    if (length <= 1) {
    //        return s;
    //    }
    //    StringBuilder sb = new StringBuilder(s);
    //    String rs = sb.reverse().toString();
    //    if (rs.equals(s)) {
    //        return s;
    //    }
    //    String longestPalindrome = "";
    //    /*
    //     * 从s的第一字符开始，和rs去比对，如果不相等找下一个，如果相同判断下一个字符是否相等。
    //     */
    //    int rsIndex = 0;
    //    int sIndex = 0;
    //    int subLength = 0;
    //    for (int i = 0; i < length; i++) {
    //        while (s.charAt(i) != rs.charAt(rsIndex)) {
    //
    //            rsIndex++;
    //        }
    //
    //    }
    //    return longestPalindrome;
    //}

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        if (rs.equals(s)) {
            return s;
        }
        String longestPalindrome = "";
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String ss = s.substring(i, j);
                if (checkPalindrome(ss)) {
                    if (ss.length() > longestPalindrome.length()) {
                        longestPalindrome = ss;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean checkPalindrome(String candidate) {
        StringBuilder sb = new StringBuilder(candidate);
        return candidate.equals(sb.reverse().toString());
    }
}
