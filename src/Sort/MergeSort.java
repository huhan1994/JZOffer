package Sort;

import java.util.Arrays;

public class MergeSort {
    public void mergesort(int[] array,int low,int high){
        if(low==high){
            return;
        }else{
            int mid=(low+high)/2;
            mergesort(array,low,mid);
            mergesort(array,mid+1,high);
            //相邻两个子集和的归并
            MergeTwoData(array,low,mid,high);
            //MergeTwoData(array,low,high);
        }
    }
    //写法一：
    public void MergeTwoData(int[] array,int low,int mid,int high){
        int[] arrcopy=new int[high-low+1]; //辅助数组
        int i=low;int m=mid;
        int j=mid+1; int n=high; //i指针指向前一个数组的头指针，j指针指向后一个数组的头指针
        int index=0;
        while(i<=m &&j<=n){  //两个数组都还没到头
            if(array[i]>array[j]){
                arrcopy[index++]=array[j];
                j++;
            }else{
                arrcopy[index++]=array[i];
                i++;
            }
        }
        while(i<=m)
            arrcopy[index++]=array[i++];
        while(j<=n)
            arrcopy[index++]=array[j++];

        //写回原数组
        int k=0;
        for(int o=low;o<=high;o++){
            array[o]=arrcopy[k++];
        }
    }
    //写法二：
    public void MergeTwoData(int[] array,int low,int high){
        int[] arrcopy=new int[high-low+1]; //辅助数组
        int i,j;
        i=low;j=(low+high)/2+1; //i指针指向前一个数组的头指针，j指针指向后一个数组的头指针
        for(int key=0;key<high-low+1;key++){   //也可以使用直接插入排序，时间复杂度更高。这里利用空间换时间
            //左侧数组指针指向右侧数组开头，说明左侧数组到头，直接把右侧数组剩下的数放入辅助数组即可
            if(i==(low+high)/2+1){
                arrcopy[key]=array[j];
                j++;
            }
            //右侧指针指向尽头的下一个位置，说明右侧数组到头，直接把左侧数组剩下的数放入辅助数组即可
            else if(j==high+1){
                arrcopy[key]=array[i];
                i++;
            }else if(array[i]<array[j]){  //左侧数组指针的数小于右侧数组指针的数
                arrcopy[key]=array[i];
                i++;
            }else{ //右侧数组指针的数小于左侧数组指针的数
                arrcopy[key]=array[j];
                j++;
            }
        }
        //写回原数组
        int index=0;
        for(int o=low;o<=high;o++){
            array[o]=arrcopy[index];
            index++;
        }
    }
    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int[] array={32,43,23,13,5,19,34,42,10,4};
//        int[] array={1,2,3,4,5,6,7,0};
        mergeSort.mergesort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
