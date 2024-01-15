package Tree;

public class SameTree {
    public static void main(String[] args) {
        SameTree tree = new SameTree();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node2.right = node3;
        node3.left = node4;
        node3.right = node5;

        TreeNode rootClone = new TreeNode(1, node1, node2);

        System.out.println("Same tree (true): " + isSameTree(root, rootClone));

        rootClone.left = node2;

        System.out.println("Different tree (false): " + isSameTree(root, rootClone));

    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        // Returns comparison if both p and q are leafs.
        if (p.left == null && p.left == p.right && p.right == q.left && q.left == q.right) {
            return p.val == q.val;
        }

        // Returns comparison and recurses with the right node.
        if (p.left == null && p.left == q.left && q.right != null && p.right != null) {
            return p.val == q.val && isSameTree(p.right, q.right);
        }

        // Returns comparison and recurses with the left node.
        if (p.right == null && p.right == q.right && q.right != null && p.right != null) {
            return p.val == q.val && isSameTree(p.left, q.left);
        }

        // Returns comparison and recurses of both the left and right sides of the node.
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
