package Solution25;

//统计一个数字在排序数组中出现的次数。
public class Solution {
    //由于数组有序，所以使用二分查找方法定位k的第一次出现位置和最后一次出现位置
    public int GetNumberOfK(int [] array , int k) {
        if(array.length<=0 ||array==null )  return 0;
        int first=GetFirstK(array,0,array.length-1,k);
        int end = GetLastK(array,0,array.length-1,k);
        if(first!=-1 && end!=-1)
            return end-first+1;
        return 0;
    }
    //递归写法
    public int GetFirstK(int[] array,int start,int end ,int k){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if(array[mid]>k){
            return GetFirstK(array,start,mid-1,k);
        }else if(array[mid]<k) {
            return GetFirstK(array, mid + 1, end, k);
        }
        //此时大前提是array[mid]==k,判断mid是否为第一个k的位置需要看mid-1是否为k
        else if(mid-1>=0 && array[mid-1]==k){
            return GetFirstK(array,start,mid-1,k);
        }else{
            return mid;
        }
    }
    //非递归写法
    public int GetLastK(int[] array,int start,int end,int k){
        int len=array.length;
        int mid;
        while(start<=end){
            mid=(start+end)>>1;
            if(array[mid]>k){
                end=mid-1;
            }else if(array[mid]<k){
                start=mid+1;
            }
            //此时大前提是array[mid]==k，判断mid是否为最后一个k需要看mid+1是否为k
            else if( mid+1<len && array[mid+1]==k){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int []arr={3,3,3,3,4,5};
        System.out.println(s.GetNumberOfK(arr,3));
    }
}
