package test;

import datastructure.FixSortedArray;

public class FixSortedArrayTest {
    public static void main(String[] args) {
        FixSortedArray array = new FixSortedArray(5);
        array.add(4);
        array.add(3);
        array.add(6);
        array.add(2);
        array.add(5);
        array.printAll();
        array.remove(1);
        array.printAll();
        array.add(1);
        array.printAll();
        array.remove(2);
        array.printAll();
        array.add(8);
        array.printAll();
        array.remove(4);
        array.printAll();
    }
}
