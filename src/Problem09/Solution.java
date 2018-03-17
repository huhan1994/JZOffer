package Problem09;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public void reOrderArray(int [] array) {
        if(array.length==0 ||array.length==1)
            return;
        int i=0;
        int j;
        while(i<array.length){
            while(((array[i]&1)==1)&&i<array.length){
                i++;
            }
            j=i+1;
            while(j<array.length && (array[j] & 1)==0){
                j++;
            }
            if(j< array.length){
                int temp=array[j];
                for(int j2=j;j2>i;j2--){
                    array[j2]=array[j2-1];
                }
                array[i]=temp;
            }else{
                break;
            }
        }
    }
    public static void main(String[] args){
        int [] arry={1,2,3,4,5,6,7};
        Solution s =new Solution();
        s.reOrderArray(arry);
        Arrays.toString(arry);
    }
}
