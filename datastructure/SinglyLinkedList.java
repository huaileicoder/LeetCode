package leetcode.LeetCode.datastructure;

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
        return removeFirstNode().item;
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

    Node<E> removeFirstNode() {
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
        return h;
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

    public boolean isEmpty() {
        return null == head;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
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


    /**
     * solution1: 遍历链表，把遍历的每一个节点作为key放进map中，如果put() return is not null, 就是一个环，但是这种方法需要node重写hash和
     * equals方法，判断equal比较麻烦，time complexity O(n^2)
     *
     * solution2: node存一个flag，遍历链表，经过节点即设为true，如果遍历的时候node flag is true，则就是环，这种需要每个节点多存一些数据
     *
     * solution3: 快慢节点，如果快慢节点相同则是环
     *
     * solution4: 2的改进版，node不存flag，增加一个Temp Node，每遍历一个节点把这个几点next指向temp，如果current node 的next指向temp
     * 说明成环，但是这一种会破坏链表结构
     *
     * 这里推荐1和3，但是1需要注意equals方法有没有好的处理方式
     */
    public boolean isCycle() {
        if (null == head || null == head.next) {
            return false;
        }
        Node<E> p = head;
        Node<E> q = head;
        while (null != q.next && null != q.next.next) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }

    public SinglyLinkedList<E> mergeOrderlyList(SinglyLinkedList<E> orderlyLinkedList) {
        if (orderlyLinkedList.isEmpty()) {
            return this;
        }
        Node<E> h = head;
        Node<E> pre = null;
        Node<E> next = h.next;
        Node<E> h2 = orderlyLinkedList.removeFirstNode();
        while (null != h) {
            if ((Integer) h2.item <= (Integer) h.item) {
                if (null == pre) {
                    h2.next = h;
                    head = h2;
                } else {
                    h2.next = h;
                    pre.next = h2;
                }
                h2 = orderlyLinkedList.removeFirstNode();
                if (null == h2) {
                    break;
                }
            }
            pre = h;
            h = next;
            if (null != next) {
                next = next.next;
            }
        }
        if (null != h2) {
            pre.next = h2;
        }
        while (orderlyLinkedList.isNotEmpty()) {
            Node<E> h3 = orderlyLinkedList.removeFirstNode();
            tail.next = h3;
            tail = h3;
        }

        return this;
    }

    public void setCycle() {
        tail.next = head;
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
