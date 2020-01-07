package binary_tree_level_order_traversal_ii;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        // Collects all nodes top down from the root.
        levelOrderTopDown(root, 0, lists);
        // Reverses the top down collection.
        Collections.reverse(lists);
        return lists;
    }
    public static void levelOrderTopDown(TreeNode node, int level,
                                         List<List<Integer>> lists) {
        // Null pointers don't contribute to the counts.
        if(node == null) {
            return;
        }
        // Keeps track of all nodes in the current level.
        List<Integer> listOfCurrentLevel = null;
        // In case, we haven't entered this level before.
        if(lists.size() == level) {
            // Make a new list for this level.
            listOfCurrentLevel = new ArrayList<Integer>();
            lists.add(listOfCurrentLevel);
        }
        else {
            // We have seen this level before.
            listOfCurrentLevel = lists.get(level);
        }
        // Add the current node for this level.
        listOfCurrentLevel.add(node.val);

        // Collect child nodes one level down.
        levelOrderTopDown(node.left, level+1, lists);
        levelOrderTopDown(node.right, level+1, lists);
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        TreeNode left1=new TreeNode(4);
        TreeNode right1=new TreeNode(5);

        treeNode.left=left;
        treeNode.right=right;
        right.left=left1;
        left.right=right1;
        System.out.println(new Solution().levelOrderBottom(treeNode));

    }
}