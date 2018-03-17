package Problem12;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        //递归版本
//        ListNode newHead=null;
//        if(list1==null){
//            return list2;
//        }
//        if(list2==null){
//            return list1;
//        }
//        if(list1.val<list2.val){
//            newHead=list1;
//            newHead.next=Merge(list1.next,list2);
//        }else{
//            newHead=list2;
//            newHead.next=Merge(list1,list2.next);
//        }
//        return newHead;

        //非递归版本
        ListNode newHead=null;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode currentNode=null;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                if(newHead==null) {
                    newHead =currentNode=list1;
                }else{
                    currentNode.next=list1;
                    currentNode=currentNode.next;
                }
                list1=list1.next;
            }else{
                if(newHead==null){
                    newHead=currentNode=list2;
                }else{
                    currentNode.next=list2;
                    currentNode=currentNode.next;
                }
                list2=list2.next;
            }
        }
        if(list1!=null){
            currentNode.next=list1;
        }
        if(list2!=null){
            currentNode.next=list2;
        }
        return newHead;
    }
}
