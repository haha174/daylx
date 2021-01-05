package before.minimum_absolut_edifference_in_bst;

import common.TreeNode;

import java.util.ArrayList;

public class Solution {
    // 二叉搜索树中序遍历解答
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        getMiddleOrder(root,result);
        int minData=Integer.MAX_VALUE;
        for (int i=1;i<result.size();i++)
        {
            int temp=result.get(i)-result.get(i-1);
            if (temp<minData){
                minData=temp;
            }
        }
        return minData;
    }

    public void getMiddleOrder (TreeNode root, ArrayList<Integer> result) {
        if (root==null) return;
        getMiddleOrder(root.left,result);
        result.add(root.val);
        getMiddleOrder(root.right,result);
    }


//    int ans = Integer.MAX_VALUE, prev = -1;
//    public int getMinimumDifference(TreeNode root) {
//        getMinimumDifference0(root);
//        return ans;
//    }
//    private void getMinimumDifference0(TreeNode node) {
//        if (node != null) {
//            getMinimumDifference0(node.left);
//            if (prev != -1) ans = Math.min(ans, node.val - prev);
//            prev = node.val;
//            getMinimumDifference0(node.right);
//        }
//    }

    public static void main(String[] args) {
        //[543,384,652,null,445,null,699]
        Integer[] data = {543,384,652,445,699};
        TreeNode root=new TreeNode(543);
        TreeNode s1=new TreeNode(384);
        TreeNode s2=new TreeNode(445);
        TreeNode s3=new TreeNode(652);
        TreeNode s4=new TreeNode(699);
        root.left=s1;
        s1.right=s2;
        root.right=s3;
        s3.right=s4;
        System.out.println(new Solution().getMinimumDifference(root));
    }

}