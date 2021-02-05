package easy.yellow.minimum_distance_between_bst_nodes;

import common.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,6,1,3,null,null]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *  
 * 注意：
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
//    public int minDiffInBST(TreeNode root) {
//        List<Integer> data=new ArrayList<>();
//        minDiffInBST(root,data);
//        int min=Integer.MAX_VALUE;
//        for (int i=1;i<data.size();i++){
//            min=Math.min(min,data.get(i)-data.get(i-1));
//        }
//        return min;
//    }
//
//    public void minDiffInBST(TreeNode root,List<Integer> data) {
//        if (root!=null){
//            minDiffInBST(root.left,data);
//            data.add(root.val);
//            minDiffInBST(root.right,data);
//        }
//    }
private int min = Integer.MAX_VALUE;
    private int pre = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null) {
            min = Math.min(min, minDiffInBST(root.left));
        }
        if(pre == Integer.MAX_VALUE)
            pre = root.val;
        else {
            min = Math.min(min, root.val-pre);
            pre = root.val;
        }
        if(root.right != null) {
            min = Math.min(min, minDiffInBST(root.right));
        }
        return min;
    }
}