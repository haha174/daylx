package middle.green.path_sumiii;

import common.TreeNode;

class Solution {
        public int pathSum(TreeNode root, long targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        public int rootSum(TreeNode root, long targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }

    public static void main(String[] args) {
        Integer[] data={10,5,-3,3,2,null,11,3,-2,null,1};
        System.out.println( new Solution().pathSum(TreeNode.generateNode(data),8));
    }
}