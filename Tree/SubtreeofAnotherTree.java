package Tree;

public class SubtreeofAnotherTree {

    public static void main(String[] args) {
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

        TreeNode subtree = new TreeNode(4, node4, node5);
        TreeNode notSubtree = new TreeNode(4, node4, null);

        System.out.println("is subtree, true: " + isSubtree(root, subtree));
        System.out.println("is not subtree, false: " + isSubtree(root, notSubtree));
    }

    static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null ^ subRoot == null)
            return false;

        if (root.val == subRoot.val)
            if (checkSubtree(root, subRoot))
                return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    public static boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null ^ subRoot == null)
            return false;

        return root.val == subRoot.val && checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);
    }
}
