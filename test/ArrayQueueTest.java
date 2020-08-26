package test;

import datastructure.CircularArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.printAll();
        print(queue.deQueue());
        queue.enQueue(5);
        queue.printAll();

    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
