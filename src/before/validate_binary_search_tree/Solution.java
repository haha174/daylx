package before.validate_binary_search_tree;

import common.TreeNode;

class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(4);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(6);

        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        System.out.println(new Solution().isValidBST(t1));
    }

}