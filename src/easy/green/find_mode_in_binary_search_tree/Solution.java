package easy.green.find_mode_in_binary_search_tree;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    int num = 0, count = 0, maxCount = 0;

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] mode = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mode[i] = list.get(i);
        }
        return mode;
    }
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        int value = root.val;
        if (value == num) {
            count++;
        } else {
            num = value;
            count = 1;
        }
        if (count > maxCount) {
            list.clear();
            list.add(value);
            maxCount = count;
        } else if (count == maxCount) {
            list.add(value);
        }
        inOrderTraversal(root.right);
    }
}