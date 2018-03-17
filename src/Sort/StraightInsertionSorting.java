package Sort;

import java.util.Arrays;

//直接插入排序
public class StraightInsertionSorting {
    public void insertSort(int[] array){
        int len=array.length;
        int numtoinsert;
        int j;
        for(int i=1;i<len;i++){
            numtoinsert=array[i];
            //把i之前大于array[i]的数往后移一位
            for(j=i-1;j>=0&&array[j]>numtoinsert;j--) {
                array[j + 1] = array[j];
            }
            array[j+1]=numtoinsert;
        }
    }

    public static void main(String[] args) {
        StraightInsertionSorting sis=new StraightInsertionSorting();
        int[] array={32,43,23,13,5};
        sis.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
