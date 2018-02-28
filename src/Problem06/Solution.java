package Problem06;

import javax.swing.tree.TreeNode;

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class Solution {

      //Definition for binary tree
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=new TreeNode(pre[0]); //前序序列第一个数为根节点
        int len=pre.length;
        if(len==0){
            root.left=null;
            root.right=null;
            return root;
        }
        int rootVal=root.val;
        int i=0;
        for(;i<len;i++){
            if(in[i]==rootVal) {
                break;
            }
        }
        //创建左子树
        if(i>0){
            int [] preleft= new int [i];
            int [] inleft=new int [i];
            for(int j=0;j<i;j++){
                preleft[j]=pre[1+j];
                inleft[j]=in[j];
            }
            root.left=reConstructBinaryTree(preleft,inleft);
        }else{
            root.left=null;
        }

        //创建右子树
        if(len-1-i>0){
            int [] preright=new int [len-i-1];
            int [] inright=new int[len-i-1];
            for(int j=i+1;j<len;j++){
                preright[j-i-1]=pre[j];
                inright[j-i-1]=in[j];
            }
            root.right=reConstructBinaryTree(preright,inright);
        }else{
            root.right=null;
        }
        return root;
    }
}
