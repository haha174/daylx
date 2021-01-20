package easy.green.merge_two_binary_trees;

import common.TreeNode;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        else {
            TreeNode root = new TreeNode();
            if (t1 == null) {
                return t2;
            } else if (t2 == null) {
                return t1;
            } else {
                root.val = t2.val + t1.val;
                root.left = mergeTrees(t1.left, t2.left);
                root.right = mergeTrees(t1.right, t2.right);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        TreeNode n15 = new TreeNode(5);

        n11.left = n13;
        n11.right = n12;
        n13.left = n15;


        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(3);
        TreeNode n24 = new TreeNode(4);
        TreeNode n27 = new TreeNode(7);

        n22.left = n21;
        n22.right = n23;
        n21.right = n24;
        n23.right = n27;

        TreeNode treeNode = new Solution().mergeTrees(n11, n22);
        System.out.println();
    }
}