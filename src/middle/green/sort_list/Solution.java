package middle.green.sort_list;

import common.ListNode;

import java.util.*;

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode result= new ListNode();
        ListNode cur=result;
        List<ListNode> listNodeList=new ArrayList<>();
        while (head!=null){
            listNodeList.add(head);
            head=head.next;
        }
        Collections.sort(listNodeList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node:listNodeList){
            cur.next=node;
            node.next=null;
            cur=node;
        }
        return result.next;
    }
}