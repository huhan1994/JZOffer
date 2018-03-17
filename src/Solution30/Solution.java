package Solution30;

import java.util.ArrayList;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
//对应每个测试案例，输出两个数，小的先输出。
public class Solution {
    //定义两个指针，分别指向数组第一个元素和最后一个元素，并计算和s。
    //若s>S，则把最后一个指针往前移动一位，再判断。
    //若s<S，则把第一个指针往后移动一位，再判断。
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(array.length<=0) return arrayList;
        int low=0;
        int high=array.length-1;
        int min=Integer.MAX_VALUE;
        while(low<high){
            int S=array[low]+array[high];
            int M=array[low]*array[high];
            if((S==sum) &&(M<min)){
                arrayList.clear();
                arrayList.add(array[low]);
                arrayList.add(array[high]);
                min=M;
            }else if(S>sum){
                high--;
            }else{
                low++;
            }
        }
        return arrayList;
    }

}
