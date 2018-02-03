package Problem03;

//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

//一个从左到右递增，一个从上到下递增，可以转换成一个从左到右递增，一个从下到上递减，从最左下角那个元素开始寻找。
public class Solution {
    public boolean Find(int target, int [][] array) {
        int rowNum = array.length;
        int colNum = array[0].length;
        int i,j=0;
        boolean flag=false;
        for(i=rowNum-1;i>=0&&j<colNum;){
            if(target==array[i][j]){
                flag=true;
                break;
            }else if(target<array[i][j]){
                i--;
            }else{
                j++;
            }
        }
        return  flag;
    }

//    public static void main(String[] args) {
//        Solution s=new Solution();
//        int [][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int target=1;
//        System.out.println(s.Find(target,array));
//    }
}
