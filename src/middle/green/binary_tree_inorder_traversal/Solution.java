package middle.green.binary_tree_inorder_traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        inorderTraversal(root,result);
        return result ;
    }

    public void inorderTraversal(TreeNode root,List<Integer> result) {
        if (root==null){
            return;
        }
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);

    }
}