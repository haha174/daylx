package binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        generateBinaryTreePaths(root,result,new ArrayList<>());
        return result;
    }
    public void generateBinaryTreePaths(TreeNode root,List<String> result,List<Integer> tmp) {
        if (root.left==null && root.right==null){
            StringBuilder sb=new StringBuilder();
            for (Integer val:tmp){
                sb.append(val);
                sb.append("->");
            }
            sb.append(root.val);
            result.add(sb.toString());
        }else{
            tmp.add(root.val);
            if (root.left!=null){
                generateBinaryTreePaths(root.left,result,tmp);
            }
            if (root.right!=null){
                generateBinaryTreePaths(root.right,result,tmp);
            }
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
//        StringBuilder sb=new StringBuilder();
//        sb.append("1->");
//        sb.append("2->");
//        sb= sb.delete(sb.length()-2,sb.length());
//        System.out.println(sb.toString());
        TreeNode node=new TreeNode(37);
        TreeNode left=new TreeNode(-34);
        TreeNode right=new TreeNode(-48);
        TreeNode left1=new TreeNode(-100);
        TreeNode right1=new TreeNode(-100);
        TreeNode right2=new TreeNode(48);

        node.left=left;
        node.right=right;
        node.left.right=left1;
        right.left=right1;
        right.right=right2;
        new Solution().binaryTreePaths(node);
    }
}