package common;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode generateListNode(Integer[] data){
        if (data==null || data.length==0) return new ListNode();
        ListNode root=new ListNode(data[0]);
        ListNode tempRoot=root;
        for (int i=1;i<data.length;i++){
            tempRoot.next=new ListNode(data[i]);
            tempRoot=tempRoot.next;
        }
        return root;
    }
}