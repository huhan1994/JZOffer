package Solution24;

import java.util.HashMap;
import java.util.List;

//输入两个链表，找出它们的第一个公共结点。
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //方法一：利用hashmap的思想
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1=pHead1;
        ListNode current2=pHead2;
        HashMap<ListNode,Integer> hashMap=new HashMap<>();
        while(current1!=null){
            hashMap.put(current1,null);
            current1=current1.next;
        }
        while(current2!=null){
            if(hashMap.containsKey(current2)){
                return current2;
            }
            current2=current2.next;
        }
        return null;
    }

    //方法二：遍历两链表，得到长度，让长的链表先走长度之差步，再一起走。
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        int len1=getlistLength(pHead1);
        int len2=getlistLength(pHead2);
        if(len1<=0||len2<=0||pHead1==null||pHead2==null){
            return null;
        }
        int diff=len1-len2;
        ListNode PlistHeadLong=pHead1;
        ListNode PlistHeadShort=pHead2;
        if(len2>len1){
            PlistHeadLong=pHead2;
            PlistHeadShort=pHead1;
            diff=len2-len1;
        }
        //长的链表先走diff步
        while(diff>0){
            PlistHeadLong=PlistHeadLong.next;
            diff--;
        }

        while((PlistHeadLong!=null)&&(PlistHeadShort!=null)&&(PlistHeadLong!=PlistHeadShort)){
            PlistHeadLong=PlistHeadLong.next;
            PlistHeadShort=PlistHeadShort.next;
        }
        ListNode firstCommonNode=PlistHeadLong;
        return firstCommonNode;

    }

    public int getlistLength(ListNode pHead){
        int length=0;
        ListNode pNode=pHead;
        while(pHead!=null){
            length++;
            pHead=pHead.next;
        }
        return length;
    }
}
