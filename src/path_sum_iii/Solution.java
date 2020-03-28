package path_sum_iii;

/**
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * countByVal 记录了 sum 值到达 那个值的 数量 相加的 意义在于 除掉这几个值 依旧能组合出 k 值
 *
 */

import java.util.HashMap;
import java.util.Map;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int pathSum(TreeNode root, int k) {
        int[] count = new int[1];
        compute(root, new HashMap<>(), k, 0, count);
        return count[0];
    }
    
    private void compute(TreeNode root, Map<Integer, Integer> countByVal, int k, int prefixSum, int[] count) {
        if (root == null)
            return;
        prefixSum += root.val;
        
        //special case for when the current path equals k
        if (prefixSum == k)
            count[0]++;
        //if there is a sum value that we can subtract from current sum to get k, add how many ways you can reach that node
        if (countByVal.getOrDefault(prefixSum - k, 0) > 0)
            count[0] += countByVal.get(prefixSum - k);
        
        countByVal.put(prefixSum, countByVal.getOrDefault(prefixSum, 0) + 1);
        
        //recursion
        compute(root.left, countByVal, k, prefixSum, count);
        compute(root.right, countByVal, k, prefixSum, count);
        
        //backtrack
        countByVal.put(prefixSum, countByVal.get(prefixSum) - 1);
    }

    public static void main(String[] args) {
        Integer[] data={1,0,1,1,2,0,-1,0,1,-1,0,-1,0,1,0};
        TreeNode treeNode=ConstructTree.constructTree( data);
        System.out.println(new Solution().pathSum(treeNode,2));
    }
}