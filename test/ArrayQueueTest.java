package leetcode.test;

import leetcode.datastructure.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.printAll();
        print(arrayQueue.deQueue());
        print(arrayQueue.deQueue());
        arrayQueue.enQueue(4);
        arrayQueue.enQueue(5);
        arrayQueue.enQueue(6);
        arrayQueue.enQueue(6);
        arrayQueue.enQueue(6);
        arrayQueue.printAll();
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
