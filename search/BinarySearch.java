package leetcode.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {30, 3300, 3900, 1, 3, 4};
        System.out.println(binarySearch(arr, 0, arr.length, 1));

        int[] arr1 = {1, 1, 3, 3, 4, 9, 20, 20, 34};
        System.out.println(binarySearchFirstValue(arr1, 0, arr1.length, 20));

        System.out.println(binarySearchFirstMajorValue(arr1, 0, arr1.length, 20));
    }

    /**
     * time complexity: O(lgn)
     */
    private static int binarySearch(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == key) {
                return mid;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch2(int[] arr, int fromIndex, int toIndex, int key) {
        // 如果已知fromIndex


        return -1;
    }

    private static int binarySearchFirstValue(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        int resultIndex = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == key) {
                high = mid - 1;
                resultIndex = mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return resultIndex;
    }

    private static int binarySearchFirstMajorValue(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= key) {
                if (mid == 0 || arr[mid - 1] < key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
