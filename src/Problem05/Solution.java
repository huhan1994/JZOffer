package Problem05;

import java.util.ArrayList;
import java.util.Stack;

//输入一个链表，从尾到头打印链表每个节点的值。

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //方法一：利用栈
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        Stack<Integer> stack=new Stack<Integer>();
//        ListNode s=listNode;
//        while(s!=null){
//            stack.push(s.val);
//            s=s.next;
//        }
//        while(!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;
//    }

    //方法二：利用递归
    ArrayList arrayList=new ArrayList<Integer>(); //因为使用递归，该函数一直被调用，所以返回的那个链表需要定义在外面
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){  //这里是if不是while
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.next);
        }
        return arrayList;
    }
}
