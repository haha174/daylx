package symmetric_tree;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * * 本题主要检查的是树是否对称
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
    //    public boolean isSymmetric(TreeNode root) {
//        if (root==null) {
//            return true;
//        }
//        StringBuilder left=new StringBuilder();
//        StringBuilder right=new StringBuilder();
//        generatorLeftSBuilder(root.left,left);
//        generatorRightSBuilder(root.right,right);
//        return left.toString().equals(right.toString());
//    }
//    public void generatorLeftSBuilder(TreeNode root,StringBuilder sb){
//        if (root==null ){
//            sb.append("a");
//            return;
//        }
//        sb.append(root.val);
//        generatorLeftSBuilder(root.left,sb);
//        generatorLeftSBuilder(root.right,sb);
//    }
//    public void generatorRightSBuilder(TreeNode root,StringBuilder sb){
//        if (root==null ){
//            sb.append("a");
//            return;
//        }
//        sb.append(root.val);
//        generatorRightSBuilder(root.right,sb);
//        generatorRightSBuilder(root.left,sb);
//    }
    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root, root);
    }

    public boolean checkMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) &&
                checkMirror(left.left, right.right) &&
                checkMirror(left.right, right.left);
    }
}