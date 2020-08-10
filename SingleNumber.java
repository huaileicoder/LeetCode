public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 4, 1};
        System.out.println(getSingleNumber(arr));
    }

    private static int getSingleNumber(int[] nums) {
        if (null == nums) {
            throw new RuntimeException("array is null");
        }
        int target;
        if (nums.length >= 1) {
            target = nums[0];
        } else {
            throw new RuntimeException("array is empty");
        }
        for (int i = 1; i < nums.length; i++) {
            target ^= nums[i];
        }
        return target;
    }
}
