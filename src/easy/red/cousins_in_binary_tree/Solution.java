package easy.red.cousins_in_binary_tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


//class Solution {
//    Map<Integer, Integer> depth;
//    Map<Integer, TreeNode> parent;
//
//    public boolean isCousins(TreeNode root, int x, int y) {
//        depth = new HashMap();
//        parent = new HashMap();
//        dfs(root, null);
//        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
//    }
//
//    public void dfs(TreeNode node, TreeNode par) {
//        if (node != null) {
//            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
//            parent.put(node.val, par);
//            dfs(node.left, node);
//            dfs(node.right, node);
//        }
//    }
//}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //这两个值任意一个都不会出现在根节点
        if(root==null||root.val==x||root.val==y)
            return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        //对应x值的结点
        TreeNode xNode=null;
        //对应y值的结点
        TreeNode yNode=null;
        //对应x值的父亲的结点
        TreeNode xFather=null;
        //对应y值的父亲的结点
        TreeNode yFather=null;
        //开始bfs
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                    //找节点
                    if(temp.left.val==x){xNode=temp.left;xFather=temp;}
                    if(temp.left.val==y){yNode=temp.left;yFather=temp;}
                }
                if(temp.right!=null){
                    q.add(temp.right);
                    //找节点
                    if(temp.right.val==x){xNode=temp.right;xFather=temp;}
                    if(temp.right.val==y){yNode=temp.right;yFather=temp;}
                }
                //两个节点都没找到，什么也不做
                if(xNode==null&&yNode==null){}
                //两个节点都找到了，那么判断它们是不是堂兄弟节点
                else if(xNode!=null&&yNode!=null){
                    //如果父亲结点不相等，说明是堂兄弟结点
                    return xFather!=yFather;
                }
                //这层遍历完了，但是有一个节点找到了，另外一个没找到
                else if(size==0)
                    return false;
            }
        }
        return false;
    }
}
