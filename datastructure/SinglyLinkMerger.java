package datastructure;

public class SinglyLinkMerger {
    public static void main(String[] args) {
        Node p = new Node(1, null);
        for (int i = 0; i < 10; i++) {
            p.next = new Node(p.val + 2, null);
        }
        Node q = new Node(2, null);
        for (int j = 0; j < 10; j++) {
            q.next = new Node(q.val + 2, null);
        }

        Node head = mergeAndReverseLink(p, q);
        while (null != head) {
            System.err.print(head.val + ", ");
            head = head.next;
        }
        System.err.println();

    }

    private static Node mergeAndReverseLink(Node p, Node q) {
        return reverseLink(mergeTwoLink(p, q));
    }

    private static Node mergeTwoLink(Node p, Node q) {
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        if (p.val < q.val) {
            p.next = mergeTwoLink(p.next, q);
            return p;
        } else {
            q.next = mergeTwoLink(p, q.next);
            return q;
        }
    }

    private static Node reverseLink(Node head) {
        if (head == null || head.next==null) {
            return head;
        }

        Node prev = null;
        Node next;
        while (head.next != null) {
            next = head.next;   //保存下一个节点
            head.next = prev;   //重置next
            prev = head;    //保存当前节点
            head = next;
        }
        head.next = prev;
        return head;
    }

    private static class Node {
        private final int val;
        private Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
