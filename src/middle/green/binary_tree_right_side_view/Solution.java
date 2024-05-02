package middle.green.binary_tree_right_side_view;

import common.ListNode;
import common.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();

        List<List<Integer>> tmp=levelOrder(root);
        for (List<Integer> list:tmp){
            result.add(list.get(list.size()-1));
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
    public static void main(String[] args) {
        Integer[] data={1,2,3,null,5,null,4};
        System.out.println(new Solution().rightSideView(common.TreeNode.generateNode(data)));;
    }
}