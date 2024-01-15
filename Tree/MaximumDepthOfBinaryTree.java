package Tree;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepth = new MaximumDepthOfBinaryTree();

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

        System.out.println("depth of 4:" + maximumDepth.maxDepth(root));

        TreeNode node6 = new TreeNode(7);
        node5.right = node6;

        System.out.println("depth of 5:" + maximumDepth.maxDepth(root));
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

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        // Returns 1 if the node is a leaf.
        if (root.left == null && root.right == null)
            return 1;

        // Returns 1 and recurses with the right node.
        if (root.left == null && root.right != null)
            return 1 + maxDepth(root.right);

        // Returns 1 and recurses with the left node.
        if (root.left != null && root.right == null)
            return 1 + maxDepth(root.left);

        // Returns the max depth of both the left and right sides of the node.
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
