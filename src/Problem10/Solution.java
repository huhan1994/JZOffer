package Problem10;

//输入一个链表，输出该链表中倒数第k个结点。

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(k<0||head==null)
            return head;
        ListNode first=head;
        ListNode second=head;
        while(k>0){
            second=second.next;
        }
        while(second.next!=null){
            second=second.next;
            head=head.next;
        }
        return head;
    }
}
