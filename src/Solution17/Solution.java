package Solution17;

import java.util.ArrayList;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class Solution {
    //方法一：基于快排的思想
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length ||k<0){
            return result;
        }
        int high=input.length-1;
        int low=0;
        int privoIndex=partition(input,low,high);
        while(privoIndex!=k-1){
            if(privoIndex>k-1){
                privoIndex=partition(input,low,privoIndex-1);
            }else{
                privoIndex=partition(input,privoIndex+1,high);
            }
        }
        for(int i=0;i<k;i++)
            result.add(input[i]);
        return result;
    }

    public int partition(int[] a,int low,int high){
        int privokey=a[low];
        while(low<high){
            while(low<high && a[high]>=privokey)
                --high;
            swap(a,low,high);
            while(low<high && a[low]<=privokey)
                ++low;
            swap(a,low,high);
        }
        return low;
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    //方法二：基于最大堆排序，保存前k个数,从第k+1个数开始调整堆
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if(k<=0 || k>input.length)  return result;
        //初始堆
        BuildHeap(input,k);
        for(int i=k;i<input.length;i++){
            if(input[i]<input[0]){
                int temp=input[0];
                input[0]=input[i];
                input[i]=temp;
                AdjustHeap(input,0,k);
            }
        }
        for(int i=0;i<k;i++)
            result.add(input[i]);
        return result;
    }

    public void BuildHeap(int[] array,int length){
        //(length-1)/2是最后一个有孩子结点的位置
        for(int i=(length-1)/2;i>=0;i--){
            AdjustHeap(array,i,length);
        }
    }

    //调整array[s],使其成为大顶堆.即将对第s个结点为根的子树筛选
    public void AdjustHeap(int[] array,int s,int length){
        int temp=array[s];
        int child=2*s+1; //左孩子结点位置
        while(child<length){
            if(child+1<length && array[child]<array[child+1])
                ++child;
            if(array[s]<array[child]){
                array[s]=array[child];
                array[child]=temp;
                s=child; //调整s结点
                child=2*s+1;  //重新调整新的s结点的左孩子结点
            }else{
                break;
            }

        }
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={5,3,7,8,10,9,2};
        int k=3;
        ArrayList<Integer> result=s.GetLeastNumbers_Solution1(a,k);
        for(Integer i:result)
            System.out.println(i);
    }
}
