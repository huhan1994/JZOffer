package Solution27;
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //重复遍历结点多次的解法
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)  return true;
        int left=depth(root.left);
        int right=depth(root.right);
        if((left-right)>1||(right-left)>1)  return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int depth(TreeNode root){
        if(root==null)  return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        return (left>right)?(left+1):(right+1);
    }

    //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
    private boolean isBanlanced=true;
    public boolean IsBalanced_Solution1(TreeNode root) {
        getdepth(root);
        return isBanlanced;
    }
    public int getdepth(TreeNode root){
        if(root==null)  return 0;
        int left=getdepth(root.left);
        int right=getdepth(root.right);
        if((left-right)>1 || (right-left)>1)
            isBanlanced=false;
        return right>left?right+1:left+1;
    }
}
