package easy.green.increasing_order_search_tree;

import common.TreeNode;

class Solution {
    TreeNode result=new TreeNode();
    TreeNode tmp=result;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        tmp.left=null;
        tmp.right=new TreeNode(root.val);
        tmp=tmp.right;
        increasingBST(root.right);
        return result.right;
    }
}