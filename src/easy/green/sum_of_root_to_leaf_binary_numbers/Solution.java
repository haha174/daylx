package easy.green.sum_of_root_to_leaf_binary_numbers;

import common.TreeNode;
import java.util.*;
class Solution {
    public int sumRootToLeaf(TreeNode root) {

        return sum(root,0);
    }
    public int sum(TreeNode root,int sum){
        if(root==null)return 0;

        sum=(sum<<1)+root.val;
        if(root.left==null&root.right==null){
            return sum;
        }
        return sum(root.left,sum)+sum(root.right,sum);
    }
//
//    int result=0;
//    public int sumRootToLeaf(TreeNode root) {
//        if (root==null ){
//            return 0;
//        }
//
//         sumRootToLeaf(root,new ArrayList<>());
//        return result;
//    }
//
//    public void sumRootToLeaf(TreeNode root,List<Integer> temp) {
//        if (root.left==null && root.right==null){
//            result+=twoToTen(temp,root.val);
//        }else {
//            temp.add(root.val);
//            if (root.left!=null){
//                sumRootToLeaf(root.left,temp);
//            }
//            if (root.right!=null){
//                sumRootToLeaf(root.right,temp);
//            }
//            temp.remove(temp.size()-1);
//        }
//
//    }
//    public int twoToTen(List<Integer> temp,int f){
//        if (temp.size()==0){
//            return f;
//        }
//        int tempInt=temp.get(0);
//        for (int i=1;i<temp.size();i++){
//            tempInt=(tempInt<<1)+temp.get(i);
//        }
//        return (tempInt<<1)+f;
//    }
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(0);
        TreeNode n3=new TreeNode(1);
        TreeNode n4=new TreeNode(0);
        TreeNode n5=new TreeNode(1);
        TreeNode n6=new TreeNode(0);
        TreeNode n7=new TreeNode(1);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        System.out.println(new Solution().sumRootToLeaf(n1));
    }
}