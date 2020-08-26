package datastructure;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TraversalTree {
    public static void main(String[] args) {

    }

    private static List<Integer> preorderTraversal(TreeNode<Integer> treeNode) {
        List<Integer> nodes = new LinkedList<>();
        if (null == treeNode) {
            return nodes;
        }
        nodes.add(treeNode.val);
        if (null != treeNode.left) {
            nodes.addAll(preorderTraversal(treeNode.left));
        }
        if (null != treeNode.right) {
            nodes.addAll(preorderTraversal(treeNode.right));
        }
        return nodes;
    }

    public static List<Integer> inorderTraversal(TreeNode<Integer> root) {
        List<Integer> nodes = new LinkedList<>();
        if (null == root) {
            return nodes;
        }
        if (null != root.left) {
            nodes.addAll(inorderTraversal(root.left));
        }
        nodes.add(root.val);
        if (null != root.right) {
            nodes.addAll(inorderTraversal(root.right));
        }
        return nodes;
    }

    public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> nodes = new LinkedList<>();
        if (null != root.left) {
            nodes.addAll(postorderTraversal(root.left));
        }
        if (null != root.right) {
            nodes.addAll(postorderTraversal(root.right));
        }
        nodes.add(root.val);
        return nodes;
    }

    private static class TreeNode<E> {
        int val;
        TreeNode<E> left;
        TreeNode<E> right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
