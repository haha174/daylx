package easy.red.maximum_difference_between_node_and_ancestor;

import common.TreeNode;

class Solution {
    private int res;

    public int maxAncestorDiff(TreeNode root) {
        this.res = 0;
        //自底向上递归
        recur(root);
        return this.res;
    }

    //返回以入参结点为根节点的树中的最小和最大值
    private int[] recur(TreeNode root) {
        if (root == null) return null;

        //如果该结点没有子节点，相当于以该结点为树的最大和最小值均为该结点的值本身，因此最大距离为0，与res比较后以数组形式返回最大最小值
        if (root.left == null && root.right == null) {
            this.res = Math.max(this.res, 0);
            return new int[]{root.val, root.val};
        }

        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        //以该结点的左子节点为根节点的树的最值
        int[] left = recur(root.left);
        //以该结点的右子结点为根节点的树的最值
        int[] right = recur(root.right);
        //不为空说明相应的子树存在
        //那么就将两颗子树中的最值再比较一次以求出以该结点为根节点的子树的最值
        if (left != null) {
            lo = Math.min(lo, left[0]);
            hi = Math.max(hi, left[1]);
        }
        if (right != null) {
            lo = Math.min(lo, right[0]);
            hi = Math.max(hi, right[1]);
        }
        //然后用最值和该结点的值求一个距离再与res比较，将大的赋给res
        this.res = Math.max(this.res, Math.max(Math.abs(root.val - lo), Math.abs(root.val - hi)));
        //然后将该结点的值与该结点子树中的最值比较，求出以该节点为根节点的树的最值，向上返回，最终自底向上多大根节点
        //这里要注意一定要将该结点本身的值与子树中的最值放一起再比较一次，因为recur方法返回值的意思就是以该方法入参结点为根节点的树的最值
        return new int[]{Math.min(lo, root.val), Math.max(hi, root.val)};
    }
}

