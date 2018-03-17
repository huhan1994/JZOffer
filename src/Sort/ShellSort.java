package Sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public void shellSort(int [] array){
        int len=array.length;
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){  //分组,有len组
                for(int j=i+len;j<array.length;j++){
                    int k;
                    int temp=array[j];
                    for(k=j-len;k>=0&&array[k]>temp;k-=len){
                        array[k+len]=array[k];
                    }
                    array[k+len]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        ShellSort sis=new ShellSort();
        int[] array={32,43,23,13,5,19,34,42,10,4};
        sis.shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
