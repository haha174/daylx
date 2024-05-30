package middle.green.construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder,  int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder,  0, n - 1, 0, n - 1);
    }
}

