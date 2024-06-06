package middle.green.flatten_binary_tree_to_linked_list;

import common.TreeNode;

class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left==null){
                root=root.right;
            }else {
                TreeNode pre= root.left;
                while (pre.right!=null){
                    pre=pre.right;
                }
                pre.right= root.right;;
                root.right=root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeNode.generateNode(new Integer[]{1,2,5,3,4,null,6});
        new Solution().flatten(treeNode);
        System.out.println(treeNode);
    }
}