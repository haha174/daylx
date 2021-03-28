package easy.green.univalued_binary_tree;

import common.TreeNode;

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return judge(root,root.val);
    }
    public boolean judge(TreeNode root,int val) {
        if(root == null) return true;
        if(root.val != val) return false;
        return judge(root.left,val) && judge(root.right,val);
    }
}
