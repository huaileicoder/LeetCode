package leetcode.sort;

public class MergeSorter {
    public static void main(String[] args) {
        int[] arr = {11, 8, 3, 9, 7, 1, 2, 5};
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
    }

    /**
     * time complexity : O(nlogn)
     * space complexity : O(n)
     */
    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int[] tmp = new int[end - start + 1];
        int i = 0;
        while (p <= mid && q <= end) {
            if (arr[p] <= arr[q]) {
                tmp[i++] = arr[p++];
            } else {
                tmp[i++] = arr[q++];
            }
        }

        int p1 = p;
        int q1 = mid;
        if (q <= end) {
            p1 = q;
            q1 = end;
        }

        while (p1 <= q1) {
            tmp[i++] = arr[p1++];
        }

        System.arraycopy(tmp, 0, arr, start, end - start + 1);
    }

    private static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + ", ");
        }
    }
}
