package balanced_binary_tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        return checkBalance(root) && isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean checkBalance(TreeNode node) {

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);

        return Math.abs(leftDepth-rightDepth) <= 1;
    }

    private int getDepth(TreeNode node) {

        if (node == null)
            return 0;

        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node3.left=node5;
        node3.right=node6;
        System.out.println(new Solution().isBalanced(root));

    }
}