package easy.green.second_minimum_node_in_a_binary_tree;

import common.TreeNode;

import java.util.*;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    // 错的
//    public int findSecondMinimumValue(TreeNode root) {
//        if (root == null) return -1;
//        else if (root.left == null) {
//            return -1;
//        } else if (root.val == root.left.val && root.val == root.right.val) {
//            return Math.max(findSecondMinimumValue(root.left), findSecondMinimumValue(root.right));
//        } else {
//            return Math.min(findSecondMinimumValue( root.left), root.right.val);
//        }
//    }
    long result=Long.MAX_VALUE;

    int min;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        min = root.val;
        getSecondMax(root);
        if (result==Long.MAX_VALUE) return -1;
        else return (int)result;
    }

    public void getSecondMax(TreeNode root) {
        if (root == null) return;
        else {
            if (root.val > min && root.val < result) {
                result = root.val;
            }
            getSecondMax(root.left);
            getSecondMax(root.right);
        }
    }
}