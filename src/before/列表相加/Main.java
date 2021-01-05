package before.列表相加;

public class Main {
	public static void main(String[] args) {
		
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {val = x;}
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int flag=0;
    	//把相加后的结果存放于链表1，pre1是用于最后有进位时在其后new新结点  
        ListNode ret = l1;  
        ListNode pre1 = new ListNode(0);  
        pre1.next = l1;  
    	while(l1!=null&&l2!=null) {
    		l1.val = l1.val + l2.val + flag;  
    		flag=l1.val/10;
    		l1.val=l1.val%10;
    		 pre1 = l1;  
    		l1=l1.next;
    		l2=l2.next;
    	}
    	 //如果链表2有剩余，接到链表1的后面  
        if (l2 != null) {  
            pre1.next = l2;  
            l1 = l2;  
        }  
        while (l1 != null) {  
            l1.val += flag;  
            flag = l1.val / 10;  
            l1.val = l1.val % 10;  
            pre1 = l1;  
            l1 = l1.next;  
        }  
          
        if (flag > 0) {  
            ListNode node = new ListNode(1);  
            pre1.next = node;  
        }  
          
    	return ret;
    }
}
