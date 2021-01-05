package before.lowest_common_ancestor_of_a_binary_search_tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root==null || (root.val>=p.val && root.val<=q.val) || (root.val>=q.val && root.val<=p.val))return root;
//        else if (root.val <= p.val && root.val<=q.val)return lowestCommonAncestor(root.right,p,q);
//        else return lowestCommonAncestor(root.left,p,q);
        TreeNode current = root;
        while(true){
            if(current.val > p.val && current.val > q.val)
                current = current.left;
            else if(current.val < p.val && current.val < q.val)
                current = current.right;
            else break;
        }
        return current;
    }
}