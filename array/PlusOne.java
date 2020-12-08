package array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {0, 0};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    private static int[] plusOne(int[] digits) {
        boolean isOverFlow = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + 1;
            if (digit > 9) {
                digits[i] = 0;
                if (i == 0) {
                    isOverFlow = true;
                }
            } else {
                digits[i] = digit;
                break;
            }
        }
        if (isOverFlow) {
            digits[0] = 0;
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
        }
        return digits;
    }
}
