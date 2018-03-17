package Sort;

import java.util.Arrays;

public class SimpleSelectionSort {
//简单选择排序
    public void SelectSort(int [] array){
        int len=array.length;
        for(int i=0;i<len;i++){
            int minIndex=selectMin(array,i);
            if(i!=minIndex){
                int temp=array[i];
                array[i]=array[minIndex];
                array[minIndex]=temp;
            }
        }

    }

    public int selectMin(int[] array,int i){
        int k=i;
        for(int j=i+1;j<array.length;j++){
            if(array[j]<array[k])
                k=j;
        }
        return k;
    }


    public static void main(String[] args) {
        SimpleSelectionSort s=new SimpleSelectionSort();
        int[] array={32,43,23,13,5,19,34,42,10,4};
        s.SelectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
