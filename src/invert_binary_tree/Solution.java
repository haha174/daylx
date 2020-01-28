package invert_binary_tree;


/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        TreeNode left1=new TreeNode(2);
        TreeNode left2=new TreeNode(1);
        TreeNode left3=new TreeNode(6);
        TreeNode right1=new TreeNode(7);
        TreeNode right2=new TreeNode(3);
        TreeNode right3=new TreeNode(9);
        root.left=left1;
        root.right=right1;
        left1.left=left2;
        left1.right=right2;
        right1.left=left3;
        right1.right=right3;
        TreeNode result=new Solution().invertTree(root);
        System.out.println(result);
    }
}