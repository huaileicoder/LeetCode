package leetcode.LeetCode;

import java.util.Collection;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size = 0;

    public SinglyLinkedList() {}

    public SinglyLinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public void add(E e) {
        addLast(e);
    }

    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e, null);
        if (null == head) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    private void addLast(E e) {
        Node<E> node = new Node<>(e, null);
        /*if (null == head) {
            head = node;
        } else {
            Node<E> p = head;
            while (null != p.next) {
                p = p.next;
            }
            p.next = node;
        }*/

        if (null == head) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public E removeFirst() {
        final Node<E> h = head;
        if (null == h) {
            throw new NoSuchElementException();
        }
        head = h.next;
        if (null == head) {
            tail = null;
        }
        h.next = null;
        size--;
        return h.item;
    }

    public E removeLast() {
        final Node<E> l = tail;
        if (null == l) {
            throw new NoSuchElementException();
        }
        Node<E> p = head;
        while (null != p.next.next) {
            p = p.next;
        }
        Node<E> r = p.next;
        p.next = null;
        tail = p;
        return r.item;
    }

    public E getFirst() {
        final Node<E> h = head;
        if (null == h) {
            throw new NoSuchElementException();
        }
        return h.item;
    }

    public E getTail() {
        final Node<E> l = tail;
        if (null == l) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    public void printAll() {
        Node<E> p = head;
        while (null != p) {
            System.out.print(p.item.toString() + ", ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public boolean isPalindrome() {
        if (null == head) {
            return false;
        }
        if (null == head.next) {
            return true;
        }
        Node<E> p = head;
        Node<E> q = head;
        while (null != q.next && null != q.next.next) {
            p = p.next;
            q = q.next.next;
        }
        Node<E> leftLink;
        Node<E> rightLink;
        if (null == q.next) {
            rightLink = p.next;
            leftLink = inverse(p).next;
        } else {
            rightLink = p.next;
            leftLink = inverse(p);
        }
        return isEquals(leftLink, rightLink);
    }

    public int getSize() {
        return size;
    }

    private Node<E> inverse(Node<E> p) {
        Node<E> r = head;
        Node<E> pre = null;
        Node<E> next;
        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return r;
    }

    private boolean isEquals(Node<E> leftLink, Node<E> rightLink) {
        Node<E> l = leftLink;
        Node<E> r = rightLink;
        while (null != l && null != r) {
            if (l.item != r.item) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
