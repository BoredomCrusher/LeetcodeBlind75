package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// LeetCode problem 104
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

        System.out.println("depth of 4:" + maximumDepth.recursiveDepth(root));

        TreeNode node6 = new TreeNode(7);
        node5.right = node6;

        System.out.println("depth of 5:" + maximumDepth.BFS(root));
    }

    // Definition for a binary tree node.
    static class TreeNode {
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

    public int recursiveDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(recursiveDepth(root.left), 
                        recursiveDepth(root.right) + 1);
    }

    public int iterativeDepth(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int maxDepth = 0;

        stack.push(root);
        map.put(root, 1);
        while (!stack.isEmpty()) {
            root = stack.pop();

            if (root.left == null && root.right == null) {
                maxDepth = Math.max(maxDepth, map.get(root));
            } else {
                if (root.left != null) {
                    stack.push(root.left);
                    map.put(root.left, map.get(root) + 1);
                } 

                if (root.right != null) {
                    stack.push(root.right);
                    map.put(root.right, map.get(root) + 1);
                }
            }
        }
        return maxDepth;
    }

    public int BFS(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        int currentLevel = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            maxDepth++;
            currentLevel = queue.size();

            for (int i = 0; i < currentLevel; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null)
                    queue.add(currentNode.left);

                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }

        return maxDepth;
    }
}
