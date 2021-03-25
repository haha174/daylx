package easy.green.range_sum_of_bst;

import common.TreeNode;

class Solution {
    int result=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null){
            return 0;
        }else if (root.val>=low && root.val<=high){
            return result+root.val+ rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }else {
            return result+ rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);

        }
    }

    public static void main(String[] args) {

    }
}