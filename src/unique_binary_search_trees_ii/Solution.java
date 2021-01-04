package unique_binary_search_trees_ii;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/cong-gou-jian-dan-ke-shu-dao-gou-jian-suo-you-shu-/
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();

        if(start > end){
            // 如果当前子树为空，不加null行吗？
            list.add(null);
            return list;
        }

        for(int i = start; i <= end; i++){
            // 想想为什么这行不能放在这里，而放在下面？
            // TreeNode root = new TreeNode(i);
            List<TreeNode> left = helper(start, i-1);  
            List<TreeNode> right = helper(i+1, end); 

            // 固定左孩子，遍历右孩子
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(5));
    }
}
