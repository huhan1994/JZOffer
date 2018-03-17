package Solution14;
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class Solution {
    public class RandomListNode {
        int label;
        RandomListNode next   = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        //第一步：复制每一个结点，并把其链接在原结点后面（如原A->B->C->D，现A->A'->B->B'->C->C'->D->D'）
        RandomListNode Node=pHead;
        while(Node!=null){
            RandomListNode copyNode=new RandomListNode(Node.label);
            copyNode.next=Node.next;
            copyNode.random=null;
            Node.next=copyNode;
            //移往下一个原结点
            Node=copyNode.next;
        }

        //第二步：设置复制出来的结点的random指针
        Node=pHead;
        //Node都指向原结点
        while(Node!=null){
            RandomListNode cNode=Node.next;
            if(Node.random!=null){
                cNode.random=Node.random.next;  //复制出来的新结点的random指针指向原Node的random指针(A)的next指针(A')
            }
            //移往下一个原结点
            Node=cNode.next;
        }

        //第三步：断开链表
        Node=pHead;
        RandomListNode copyHead=null;
        RandomListNode cNode=null;
        if(Node!=null){
            copyHead=cNode=Node.next; //确定复制链表的头结点
            Node.next=copyHead.next; //断开
            Node=Node.next;
        }

        //移往下一个原结点
        while(Node!=null){
            cNode.next=Node.next;
            cNode=cNode.next;
            Node.next=cNode.next;
            Node=Node.next;
        }
        return  copyHead;
    }
}
