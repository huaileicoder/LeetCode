package leetcode.datastructure;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 1 << 4;

    private Object[] elements;
    private int count;
    private int capacity;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized E pop() {
        if (count <= 0) {
            return null;
        }
        Object item = elements[--count];
        return (E) item;
    }

    @Override
    public synchronized void push(E e) {
        ensureCapacity(count + 1);
        elements[count++] = e;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            if (newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
