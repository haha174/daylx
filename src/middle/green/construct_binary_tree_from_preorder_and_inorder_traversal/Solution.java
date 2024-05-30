package middle.green.construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
//[3,9,20,15,7], inorder = [9,3,15,20,7]
class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder,  int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_right<preorder_left){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preorder_left]);
        int inorderIndex=indexMap.get(preorder[preorder_left]);
        int leftCount= inorderIndex-inorder_left;
        root.left=myBuildTree(preorder,preorder_left+1,preorder_left+leftCount,inorder_left,  inorderIndex-1);
        root.right=myBuildTree(preorder,preorder_left+leftCount+1,preorder_right,inorderIndex+1,  inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder,  0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] t1={3,9,20,15,7};
        int[] t2={9,3,15,20,7};
       TreeNode root= new Solution().buildTree(t1,t2);
        System.out.println(root);
    }
}

