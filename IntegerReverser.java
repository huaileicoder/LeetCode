package leetcode.LeetCode;

public class IntegerReverser {
    
    public static int reverse(int x) {
        boolean isNegative = x < 0;
        String xString = String.valueOf(x);
        if (isNegative) {
            xString = xString.substring(1);
        }
        StringBuilder stringBuilder = new StringBuilder(xString);
        stringBuilder.reverse();
        if (isNegative) {
            stringBuilder.insert(0, "-");
        }
        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
