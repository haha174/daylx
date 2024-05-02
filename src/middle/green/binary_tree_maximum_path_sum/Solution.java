package middle.green.binary_tree_maximum_path_sum;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        fs(root);
       return max;
    }
    public int fs(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftValue=Math.max(fs(root.left),0);
        int rightValue=Math.max( fs(root.right),0);
        int nodeMax=leftValue+rightValue+root.val;
        max=Math.max(max,nodeMax);
        return root.val +Math.max(leftValue, rightValue);
    }

    public static void main(String[] args) {
        Integer data[]={5,4,8,11,null,13,4,7,2,null,null,null,1};
        System.out.println(new Solution().maxPathSum(TreeNode.generateNode(data)));
    }
}
//
////
//class Solution {
//    int maxSum = Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root) {
//        maxGain(root);
//        return maxSum;
//    }
//
//    public int maxGain(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        // 递归计算左右子节点的最大贡献值
//        // 只有在最大贡献值大于 0 时，才会选取对应子节点
//        int leftGain = Math.max(maxGain(node.left), 0);
//        int rightGain = Math.max(maxGain(node.right), 0);
//
//        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
//        int priceNewpath = node.val + leftGain + rightGain;
//
//        // 更新答案
//        maxSum = Math.max(maxSum, priceNewpath);
//
//        // 返回节点的最大贡献值
//        return node.val + Math.max(leftGain, rightGain);
//    }
//
//    public static void main(String[] args) {
//        Integer data[] = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
//        System.out.println(new Solution().maxPathSum(TreeNode.generateNode(data)));
//    }
//}

