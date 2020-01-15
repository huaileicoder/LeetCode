package leetcode.LeetCode;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        int divisor;
        int remainder;
        while (temp > 0) {
            divisor = temp / 10;
            remainder = temp % 10;
            result = result * 10 + remainder;
            temp = divisor;
        }

        return result == x;
    }
}
