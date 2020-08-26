package test;

import datastructure.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        /*SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>(getList());
        linkedList.setCycle();
        System.out.println("is cycle，" + linkedList.isCycle());*/

        SinglyLinkedList<Integer> linkedList1 = new SinglyLinkedList<>(getList());
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>(getList2());
        linkedList1.mergeOrderlyList(linkedList2);
        linkedList1.printAll();

    }

    private static Collection<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        return list;
    }

    private static Collection<Integer> getList2() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        return list;
    }



}
