package datastructure;

public class CircularArrayQueue<E> implements Queue<E> {
    private Object[] items;
    private int capacity;
    private int head;
    private int tail;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    @Override
    public void enQueue(E e) {
        if (head == (tail + 1) % capacity) {
            throw new ArrayIndexOutOfBoundsException("head" + head + ", tail=" + tail);
        }
        items[tail] = e;
        tail = (tail + 1) % capacity;
    }

    @Override
    public E deQueue() {
        if (head == tail) {
            return null;
        }
        E e =  (E) items[head];
        head = (head + 1) % capacity;
        return e;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i]);
        }
        System.out.println();
    }
}
