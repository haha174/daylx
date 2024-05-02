package before.convert_sorted_array_to_binary_search_tree;

/**
 *
 */

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length-1);
    }

    TreeNode createTree(int[] nums,int s, int e){
        if (s>e){
            return null;
        }
       int mid=(s+e)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=createTree(nums,s,mid-1);
        node.right =createTree(nums,mid+1,e);
        return node;
    }
}