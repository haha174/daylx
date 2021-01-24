package easy.green.trim_a_binary_search_tree;

import common.TreeNode;

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n0=new TreeNode(0);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);

        n3.left=n0;
        n3.right=n4;
        n0.right=n2;
        n2.left=n1;

        TreeNode treeNode=new Solution().trimBST(n3,1,3);
        System.out.println();
    }
}