package middle.green.kth_smallest_element_in_a_bst;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        kthSmallest(root,list);
        return list.get(k-1);
    }

    public void kthSmallest(TreeNode root, List<Integer> k) {
        if (root==null){
            return;
        }
        kthSmallest(root.left,k);
        k.add(root.val);
        kthSmallest(root.right,k);

    }

    public static void main(String[] args) {
        Integer[] data={3,1,4,null,2};
        System.out.println(new Solution().kthSmallest(common.TreeNode.generateNode(data),1));
    }

}