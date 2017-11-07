package AddTwoNumbers;

public class Main {
	public static void main(String args[]) {
		ListNode l=new ListNode(2);
		ListNode h=new ListNode(5);
		ListNode l1=new ListNode(4);
		ListNode l2=new ListNode(3);
		ListNode l3=new ListNode(6);
		ListNode l4=new ListNode(4);
       l.next=l1;
       l1.next=l2;
       h.next=l3;
       l3.next=l4;
       print(  addTwoNumbers(l,h));
	}
    public static ListNode addTwoNumbers(ListNode c1, ListNode c2) {
        ListNode sen = new ListNode(0);//  保存 生成  新的列表的  根节点引用
        ListNode d = sen;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;//进位处理
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 >= 1)//处理最后遗留的进位
            d.next = new ListNode(sum / 10);
        return sen.next; //当前的根节点  是空的   在上文中创建并没有赋值   真正的根节点是他的下一个节点
    }
    public static void print(ListNode c1) {
    	   while (c1 != null)
    	   {
    		   System.out.print(c1.val);
    		   if(c1.next!=null)
    		   {
        		   System.out.print("->");
    		   }
    		   c1=c1.next;
    		   
    	   }
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}