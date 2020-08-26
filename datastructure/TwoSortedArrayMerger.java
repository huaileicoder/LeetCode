package datastructure;

public class TwoSortedArrayMerger {
    public static void main(String[] args) {
        FixSortedArray array1 = getArray1();
        FixSortedArray array2 = getArray2();
        int newCapacity = array1.getCount() + array2.getCount();
        int[] newArray = new int[newCapacity];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < array1.getCount() && j < array2.getCount()) {
            int iV = array1.get(i);
            int jV = array2.get(j);
            if (iV <= jV) {
                newArray[index++] = iV;
                i++;
            } else {
                newArray[index++] = jV;
                j++;
            }
        }
        while (i < array1.getCount()) {
            newArray[index++] = array1.get(i++);
        }
        while (j < array2.getCount()) {
            newArray[index++] = array2.get(j++);
        }

        printAll(newArray);
    }

    private static FixSortedArray getArray1() {
        FixSortedArray array = new FixSortedArray(5);
        array.add(1);
        array.add(3);
        array.add(4);
        return array;
    }

    private static FixSortedArray getArray2() {
        FixSortedArray array = new FixSortedArray(5);
        array.add(2);
        array.add(3);
        array.add(5);
        array.add(7);
        array.add(71);
        return array;
    }

    private static void printAll(int[] array) {
        for (int a : array) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
}
