package Solution26;

import java.util.LinkedList;
import java.util.Queue;

//输入一棵二叉树，求该树的深度。
// 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归版本
    public int TreeDepth(TreeNode root) {
        if(root==null)  return 0;
        int nLeft=TreeDepth(root.left);
        int nRight=TreeDepth(root.right);
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }
    //基于层次遍历
    //数据结构队列 queue
    public int TreeDepth1(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int depth=0,count=0,nextcount=1;  //nextcount为该层应有的节点个数
        while(queue.size()!=0){
            TreeNode top=queue.poll();  //出队时统计本层节点个数
            count++;
            if(top.left!=null){
                queue.add(top.left);
            }
            if(top.right!=null){
                queue.add(top.right);
            }
            if(count==nextcount){ //此时该层已经遍历完，队列中的元素应为下一层结点个数
                depth++;
                count=0;
                nextcount=queue.size();
            }
        }
        return depth;
    }
}
