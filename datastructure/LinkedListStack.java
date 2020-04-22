package leetcode.LeetCode.datastructure;

public class LinkedListStack<E> implements Stack<E> {
    private SinglyLinkedList<E> linkedList;

    @Override
    public E pop() {
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList.removeLast();
    }

    @Override
    public void push(E e) {
        linkedList.add(e);
    }

    public int getCount() {
        return linkedList.getSize();
    }

}
