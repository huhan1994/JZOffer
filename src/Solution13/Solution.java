package Solution13;

import java.util.ArrayList;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class Solution {
    public ArrayList<Integer> result=new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        if(matrix==null || row<0 || col<0){
            return null;
        }
        int count=0;
        while(col>count*2 && row>count*2){
            PrintCircle(matrix,col,row,count);
            count++;
        }
        return result;
    }

    public void PrintCircle(int [][] matrix,int col,int row,int start){
        int endrow=row-start-1;
        int endcol=col-start-1;
        //从左到右打印一行
        //第一行一定会打印的
        for(int i=start;i<=endcol;i++){
            result.add(matrix[start][i]);
        }
        //从上往下打印（第二步）
        if(endrow>start){
            for(int i=start+1;i<=endrow;i++){
                result.add(matrix[i][endcol]);
            }
        }
        //从右往左打印（第三步）
        if(endrow>start && endcol>start){
            for(int i=endcol-1;i>=start;i--){
                result.add(matrix[endrow][i]);
            }
        }
        //从下往上打印（第四步）
        if((endrow-start>1)&&endcol>start){
            for(int i=endrow-1;i>start;i--){
                result.add(matrix[i][start]);
            }
        }
    }
}
