package easy.green.n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
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

    public List<Integer> postorder(Node root) {
        if (root != null) {
            if (root.children != null && root.children.size() > 0) {
                for (Node child : root.children) {
                    postorder(child);
                }
                result.add(root.val);
            }
        }
        return result;
    }

}