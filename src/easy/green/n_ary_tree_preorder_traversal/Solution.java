package easy.green.n_ary_tree_preorder_traversal;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            result.add(root.val);
            if (root.children != null && root.children.size() > 0) {
                for (Node child:root.children){
                    preorder(child);
                }
            }
        }
        return result;
    }
}