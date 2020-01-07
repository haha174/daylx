package minimum_depth_of_binary_tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
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
    /**
     * public int minDepth(TreeNode root) {
     *
     *         if ( root == null){
     *             return 0;
     *         }
     *         if ( root.right == null){
     *             return 1 + minDepth(root.left);
     *         }
     *         if ( root.left == null){
     *             return 1 + minDepth(root.right);
     *         }
     *
     *         return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
     *     }
     */
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left==null){
            return minDepth(root.right)+1;
        }else if (root.right==null){
            return minDepth(root.left)+1;
        }else {
            return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
        }
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
        System.out.println(new Solution().minDepth(root));
    }
}