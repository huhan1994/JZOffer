package Problem11;
//输入一个链表，反转链表后，输出链表的所有元素。
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode currentNode=head;
        ListNode preNode=null;
        ListNode ReverseHead=null;
        while(currentNode!=null){
            ListNode nextNode=currentNode.next;
            if(nextNode==null){
                ReverseHead=currentNode;
            }
            currentNode.next=preNode;
            preNode=currentNode;
            currentNode=nextNode;
        }
        return ReverseHead;
    }
}
