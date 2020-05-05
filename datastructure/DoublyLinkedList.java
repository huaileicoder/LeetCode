package leetcode.datastructure;

public class DoublyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    private int size;

    public DoublyLinkedList() {}

    public void add(E e) {
        linkLast(e);
    }

    public void add(int index, E e) {
        checkElementIndex(index);
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, indexNode(index));
        }
    }

    private void linkFirst(E e) {
        final Node<E> f = this.first;
        final Node<E> newNode = new Node<>(e, f, null);
        this.first = newNode;
        if (null == f) {
            last = newNode;
        } else {
            f.pre = newNode;
        }
        size++;
    }

    private void linkLast(E e) {
        final Node<E> l = this.last;
        final Node<E> newNode = new Node<>(e, null, l);
        this.last = newNode;
        if (null == l) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void linkBefore(E e, Node<E> current) {
        Node<E> newNode = new Node<>(e, current, null);
        Node<E> pre = current.pre;
        newNode.pre = pre;
        current.pre = newNode;
        if (null == pre) {
            this.first = newNode;
        } else {
            pre.next = newNode;
        }
        size++;
    }

    private Node<E> indexNode(int index) {
        if (index < (size >> 1)) {
            Node<E> indexNode = this.first;
            for (int i = 0; i < index; i++) {
                indexNode = indexNode.next;
            }
            return indexNode;
        } else {
            Node<E> indexNode = this.last;
            for (int i = size - 1; i > index; i--) {
                indexNode = indexNode.pre;
            }
            return indexNode;
        }
    }

    public E remove(int index) {
        return null;
    }

    public E remove(E e) {
        return null;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
        }
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> pre;

        public Node(E item, Node<E> next, Node<E> pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }
}
