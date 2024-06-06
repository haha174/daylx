package middle.green.construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
//[3,9,20,15,7], inorder = [9,3,15,20,7]
class Solution {
    private Map<Integer, Integer> indexMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
       return myBuildTree(preorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode myBuildTree(int[] preorder,  int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left>=preorder.length ||preorder_left>preorder_right ||inorder_left>inorder_right ){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preorder_left]);
        Integer inorderIndex=indexMap.get(preorder[preorder_left]);
        int gap=inorderIndex-inorder_left;
        root.left=myBuildTree(preorder,preorder_left+1,preorder_left+gap,inorder_left,inorderIndex-1);
        root.right=myBuildTree(preorder,preorder_left+gap+1,preorder_right,inorderIndex+1,inorder_right);
        return root;
    }



    public static void main(String[] args) {
        int[] t1={3,9,20,15,7};
        int[] t2={9,3,15,20,7};
       TreeNode root= new Solution().buildTree(t1,t2);
        System.out.println(root);
    }
}

