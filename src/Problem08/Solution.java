package Problem08;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

public class Solution {
//    public int minNumberInRotateArray(int [] array) {
//        if(array.length==0){
//            return 0;
//        }
//        //使用二分查找
//        int low=0; int high=array.length-1;
//        while(low<high){
//            int mid=low+(high-low)/2;
//            if(array[mid]>array[high]){ //说明mid在前面的一段递增数组中
//                low=mid+1;
//            }else if(array[mid]<array[high]){
//                high=mid;
//            }else{
//                high=high-1;
//            }
//        }
//        return array[low];
//    }

    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        //使用二分查找
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(array[left]>=array[right]){
            //分界点
            if(right-left==1){
                mid=right;
                break;
            }
            mid=(left+right)/2;
            if(array[left]==array[right]&&array[left]==array[mid]){
                return minOrder(array,left,right);
            }
            if(array[mid]>=array[left]){
                left=mid;
            }else{
                right=mid;
            }
        }
        return array[mid];
    }

    private  int minOrder(int [] array,int left,int right){
        int result=array[left];
        for(int i=left+1;i<right;i++){
            if(array[i]<result){
                result=array[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] array={3,4,5,1,2};
        Solution s=new Solution();
        System.out.println(s.minNumberInRotateArray(array));
    }
}
