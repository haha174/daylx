package maximum_depth_of_binary_tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
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
    public int maxDepth(TreeNode root) {

        return getMaxDepth(root);
    }

    public int getMaxDepth(TreeNode root) {
        if (root==null ){
            return 0;
        }
            return  Math.max(1+getMaxDepth(root.left) ,1+getMaxDepth(root.right) ) ;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        TreeNode left=new TreeNode(1);
        TreeNode right=new TreeNode(1);
        TreeNode left1=new TreeNode(1);

        treeNode.left=left;
        treeNode.right=right;
        right.left=left1;
        System.out.println(new Solution().getMaxDepth(treeNode));

    }
}