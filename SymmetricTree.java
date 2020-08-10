public class SymmetricTree {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode<Integer> root) {
        if (null == root) {
            return true;
        }
        return equals(root.left, root.right);
    }

    public static boolean equals(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return p.val == q.val && equals(p.left, q.right) && equals(p.right, q.left);
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
