package easy.green.construct_string_from_binary_tree;

import common.TreeNode;

import java.util.TreeMap;

class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder();
        dfs(t, builder);
        return builder.toString();
    }
    public void dfs(TreeNode t,StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if ((t.left != null)|| (t.right!=null)) {
                sb.append("(");
                dfs(t.left,sb);
                sb.append(")");
            }
            if (t.right != null) {
                sb.append("(");
                dfs(t.right,sb);
                sb.append(")");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        System.out.println(new Solution().tree2str(n1));
    }
}