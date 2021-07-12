package middle.green.binary_tree_zigzag_level_order_traversal;

import common.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean reserveFlag=true;
        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int currentSize=queue.size();
            for (int i=0;i<currentSize;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            reserveFlag=!reserveFlag;
            if (reserveFlag) {
                Collections.reverse(level);
            }
            ret.add(level);
        }
        return ret;

    }


    public static void main(String[] args) {
        Integer[] data = {1, 2, null, 3, null, 4, null, 5};
        TreeNode root = TreeNode.generateNode(data);
        new Solution().zigzagLevelOrder(root);
        System.out.println();
    }
}