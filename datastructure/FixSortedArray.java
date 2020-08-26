package datastructure;

public class FixSortedArray {
    private int[] elements;
    private int count;

    public FixSortedArray(int capacity) {
        elements = new int[capacity];
    }

    public void add(int e) {
        if (count >= elements.length) {
            throw new ArrayIndexOutOfBoundsException(count);
        }
        insertAndSort(e);
    }

    public int remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index >= count) {
            return 0;
        }
        int r = elements[index];
        moveElementLeftOne(index + 1);
        count--;
        return r;
    }

    public int get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return elements[index];
    }

    public void printAll() {
        for (int e : elements) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }

    private void insertAndSort(int e) {
        if (count <= 0 || e >= elements[count - 1]) {
            elements[count++] = e;
            return;
        }
        int c = 0;
        while (c < count) {
            if (e < elements[c]) {
                moveElementRightOne(c);
                elements[c] = e;
                count++;
                return;
            }
            c++;
        }
    }

    private void moveElementRightOne(int startIndex) {
        int c = count - 1;
        while (c >= startIndex) {
            elements[c + 1] = elements[c];
            c--;
        }
    }

    private void moveElementLeftOne(int startIndex) {
        int c = startIndex;
        while (c < count) {
            elements[c - 1] = elements[c];
            c++;
        }
        elements[elements.length - 1] = 0;
    }

    public int getCount() {
        return count;
    }
}
