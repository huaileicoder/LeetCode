package datastructure;


public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 1 << 4;

    private Object[] items;
    private int capacity;
    /** 头位置下标 */
    private int head;
    /** 尾位置下标*/
    private int tail;

    public ArrayQueue(int capacity) {
        items = new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayQueue() {
        items = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public void enQueue(E e) {
        if (tail >= capacity) {
            moveLeft();
        }
        items[tail++] = e;
    }

    @Override
    public E deQueue() {
        if (head == tail) {
            return null;
        }
        return (E) items[head++];
    }

    private void moveLeft() {
        if (head <= 0) {
            throw new ArrayIndexOutOfBoundsException(tail);
        }
        if (head >= tail) {
            head = tail = 0;
            return;
        }
        int h = head;
        for (int i = 0; i < tail - head; i++, h++) {
            items[i] = items[h];
            items[h] = null;
        }
        tail -= head;
        head = 0;
    }

    public void printAll() {
        for (Object o : items) {
            System.out.print(o + ", ");
        }
        System.out.println();
    }
}
