package Sort;

import java.util.Arrays;

//折半插入排序
public class HalfInsertSorting {
    public void InsertSort(int [] array){
        int len=array.length;
        int mid,low,high;
        int key;
        for(int i=1;i<len;i++){
            key=array[i];
            low=0;high=i-1;
            while(low<=high){
                mid=(low+high)/2;
                if(array[mid]==key)
                    break;
                else if(key>array[mid]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            //low的索引位置就是即将要插入的位置
            //移动low索引位置后面的元素
            for(int j=i-1;j>=low;j--){
                array[j+1]=array[j];
            }
            array[low]=key;
        }
    }
    public static void main(String[] args) {
        HalfInsertSorting sis=new HalfInsertSorting();
        int[] array={32,43,23,13,5};
        sis.InsertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
