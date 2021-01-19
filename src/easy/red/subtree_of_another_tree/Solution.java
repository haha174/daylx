package easy.red.subtree_of_another_tree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // 错的
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//      return isSubtree1(s,t,t);
//    }
//
//
//    public boolean isSubtree1(TreeNode s, TreeNode t,TreeNode t1) {
//        if (t == null && s==null) {
//            return true;
//        } else if (s == null ||  t == null) {
//            return false;
//        } else {
//            if (s.val == t.val) {
//                return (isSubtree1(s.left, t.left,t1) && isSubtree1(s.right, t.right,t1))|| isSubtree1(s.left, t,t1) || isSubtree1(s.right, t,t1);
//            } else {
//                return isSubtree1(s.left, t1,t1) || isSubtree1(s.right,  t1,t1);
//            }
//        }
//    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }


    public static void main(String[] args) {


        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(5);
        TreeNode n4=new TreeNode(1);
        TreeNode n5=new TreeNode(2);
        TreeNode n6=new TreeNode(0);
        n5.left=n6;
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;



        TreeNode n7=new TreeNode(4);
        TreeNode n8=new TreeNode(1);
        TreeNode n9=new TreeNode(2);
        n7.left=n8;
        n7.right=n9;

//        TreeNode n1=new TreeNode(1);
//        TreeNode n2=new TreeNode(1);
//        TreeNode n3=new TreeNode(1);
//
//        n1.left=n2;

        System.out.println(new Solution().isSubtree(n1,n7));

    }
}