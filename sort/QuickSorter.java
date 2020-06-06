package leetcode.sort;

public class QuickSorter {
    public static void main(String[] args) {
        int[] arr = {6, 8, 7, 6, 3, 5, 9, 4, 10, 1, 0, 2};
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start;
        for (int j = start; j <= end; j++) {
            if (arr[j] < arr[pivot]) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = tmp;
        return i;
    }

    private static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }


}
