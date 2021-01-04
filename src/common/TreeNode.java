package common;

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

