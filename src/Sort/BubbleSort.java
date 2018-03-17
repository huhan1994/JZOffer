package Sort;

import java.util.Arrays;

public class BubbleSort {
    public void bubblesort(int[] array){
        int len=array.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void bubblesort1(int[] array){
        int len=array.length;
        int i=len-1; //初始时，最后位置保持不变
        while (i>0){
            int pos=0; //每趟开始的时候，无记录交换
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    pos=j; //记录交换的位置
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            i=pos;  //pos为最后交换的位置
        }
    }

    public void bubblesort2(int[] array){
        int len=array.length;
        int low=0;
        int high=len-1;
        int j;
        while(low<high){
            for(j=low;j<high;j++){ //正向冒泡，找到最大值
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            --high;
            for(j=high;j>low;j--){ //反向冒泡，找到最小值
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            ++low;
        }
    }

    public static void main(String[] args) {
        BubbleSort bs=new BubbleSort();
        int[] array={32,43,23,13,5,19,34,42,10,4};
        bs.bubblesort2(array);
        System.out.println(Arrays.toString(array));
    }
}
