package leetcode.search;

public class RotatedSortedArraySearcher {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.println("search index:" + search(arr, 2));
    }

    private static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int resultIndex = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[low] < arr[mid]) {
                resultIndex = binarySearch(arr, low, mid, target);
                if (resultIndex > -1) {
                    return resultIndex;
                }
                low = mid + 1;
            } else {
                resultIndex = binarySearch(arr, mid + 1, high, target);
                if (resultIndex > -1) {
                    return resultIndex;
                }
                high = mid - 1;
            }
        }

        return resultIndex;
    }

    private static int binarySearch(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex;

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
}
