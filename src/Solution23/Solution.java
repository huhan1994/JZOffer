package Solution23;

import java.util.Arrays;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
//输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
public class Solution {
    //顺序比较
    public int InversePairs(int [] array) {
        int count=0;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    ++count;
                }
            }
        }
        return count%1000000007;
    }

    //基于归并排序
    int count=0;
    public int InversePairs1(int [] array) {
        if(array.length==0) return 0;
        int low=0;
        int high=array.length-1;
        mergesort(array,low,high);
        return count%1000000007;
    }

    public void mergesort(int[] array,int low,int high){
        if(low==high){
            return;
        }else{
            int mid=(low+high)/2;
            mergesort(array,low,mid);
            mergesort(array,mid+1,high);
            //相邻两个子集和的归并
            MergeTwoData(array,low,mid,high);
        }
    }

    public void MergeTwoData(int[] array,int low,int mid,int high){
        int[] arrcopy=new int[high-low+1]; //辅助数组
        int i=low;int m=mid;
        int j=mid+1; int n=high; //i指针指向前一个数组的头指针，j指针指向后一个数组的头指针
        int index=0;
        while(i<=m &&j<=n){  //两个数组都还没到头
            if(array[i]>array[j]){
                arrcopy[index++]=array[j];
                j++;
                count+=m-i+1; //当前left元素及其右边元素都比当前right大
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


    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,2,3,4,5,6,7,0};

        System.out.println(s.InversePairs1(a));
        s.InversePairs1(a);
        System.out.println(Arrays.toString(a));
    }
}
