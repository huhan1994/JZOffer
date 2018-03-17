package Solution15;

import java.util.Stack;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归做法
    //1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
    //2、定位到左链表的最后一个节点(左子树最右边的节点)
    //3、如果左子树链表不为空，则将当前root追加到左子树链表后
    //4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
    //5、如果右子树链表不为空，将右子树链表追加到当前root后
    //6、根据左子树链表是否为空返回的整体双向链表的头节点

    //Convert函数把一个二叉搜索树变成一个有序的双向链表，返回双向链表的头结点，参数root为二叉搜索树的根节点
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree==null)  return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null)   return pRootOfTree;
        //1.将0左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
        TreeNode left=Convert1(pRootOfTree.left);

        //2、定位到左链表的最后一个节点(左子树最右边的节点)
        TreeNode p=left; // 创建临时结点p来寻找左链表最后一个结点（左子树最右结点）
        while(p!=null &&p.right!=null){
            p=p.right;
        }

        //3、如果左子树链表不为空，则将当前root追加到左子树链表后
        if(left!=null){
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }

        //4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
        TreeNode right=Convert1(pRootOfTree.right);

        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if(right!=null){
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }

        //6、根据左子树链表是否为空返回的整体双向链表的头节点
        return (left==null)?pRootOfTree:left;
    }

    //非递归做法：类似中序遍历
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree==null)   return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=pRootOfTree; //p保存临时结点
        TreeNode pre=null; //保存中序遍历结点顺序上的上一个结点
        TreeNode rootlist=null; //用于记录双向链表头结点
        boolean isFirst=true; //判断是否为左子树第一个结点
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if(isFirst){
                rootlist=p;
                pre=p;
                isFirst=false;
            }else{
                pre.right=p;
                p.left=pre;
                pre=p;
            }
            p=p.right;
        }
        return rootlist;
    }
}
