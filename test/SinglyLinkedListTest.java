package leetcode.LeetCode.test;

import leetcode.LeetCode.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>(getList());
        System.out.println("是否是回文，" + linkedList.isPalindrome());
    }

    private static Collection<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(1);
        return list;
    }
}
