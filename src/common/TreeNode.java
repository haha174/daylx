package common;


import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public  int val;
  public  TreeNode left;
    public  TreeNode right;
    public  TreeNode(int x) { val = x; }
    public TreeNode() {  }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    // 构造一个二叉搜索树
    public static TreeNode generateNode(Integer[] nums){
        if (nums.length == 0) return new TreeNode(0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        int lineNodeNum = 2;
        int startIndex = 1;
        int restLength = nums.length - 1;
        while(restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] data={1,2,3,4,1,1,1,1,1,2,3,3,1,12,3,1,23,12,31,13,13,13,131,3,13,1,3,1};
        System.out.println( TreeNode.generateNode(data));
    }


    public static TreeNode generateSearchNode(Integer[] data){
        if (data.length==0)return new TreeNode();
        TreeNode root=new TreeNode(data[0]);
        for (int i=1;i<data.length;i++){
            TreeNode tempNode=root;
            while (true){
                if (tempNode.val>=data[i] && tempNode.left!=null){
                    tempNode=tempNode.left;
                }else if (tempNode.val<data[i] && tempNode.right!=null){
                    tempNode=tempNode.right;
                }else {
                    break;
                }
            }
            if (tempNode.val>=data[i]){
                tempNode.left=new TreeNode(data[i]);
            }else{
                tempNode.right=new TreeNode(data[i]);
            }

        }
        return root;
    }
//    public static TreeNode generateSearchNode(Integer[] data,int index){
//        if (data.length==0)return new TreeNode();
//        TreeNode root=new TreeNode(data[0]);
//        return generateSearchNode(root,data,1);
//    }
//    private static TreeNode generateSearchNode(TreeNode root,Integer[] data,int index){
//
//    }
}

