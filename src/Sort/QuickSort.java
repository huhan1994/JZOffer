package Sort;

import java.util.Arrays;

public class QuickSort {
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

    public void QuickSort(int[] a,int low,int high){
        if(low<high){
            int privocLoc=partition(a,low,high);
            QuickSort(a,low,privocLoc-1);
            QuickSort(a,privocLoc+1,high);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        QuickSort q=new QuickSort();
        int[] array={32,43,23,13,5,19,34,42,10,4};
        q.QuickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
