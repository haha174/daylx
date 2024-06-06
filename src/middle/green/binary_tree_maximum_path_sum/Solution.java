package middle.green.binary_tree_maximum_path_sum;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private Integer dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer value=root.val;
        Integer leftValue=Math.max(dfs(root.left),0);
        Integer rightValue=Math.max(dfs(root.right),0);
        max=Math.max(max,value+leftValue+rightValue);
        return Math.max(leftValue+value,rightValue+value);

    }


    public static void main(String[] args) {
        Integer data[] = {-10,9,20,null,null,15,7};
        System.out.println(new Solution().maxPathSum(TreeNode.generateNode(data)));
    }
}


