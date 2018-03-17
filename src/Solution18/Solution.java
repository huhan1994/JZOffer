package Solution18;
//HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
// 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
// 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
// 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length<=0) return 0;
        int maxOfAllSubArray=Integer.MIN_VALUE;
        for(int i=0;i<array.length-1;i++){
            int max=maxofSubArray(array,i,array.length);
            if(maxOfAllSubArray<max){
                maxOfAllSubArray=max;
            }
        }
        return maxOfAllSubArray;
    }

    public int maxofSubArray(int[]array,int begin,int end){
        int cal=array[begin];
        int max=array[begin];
        for(int i=begin+1;i<end;i++){
            cal+=array[i];
            if(cal>max)
                max=cal;
        }
        return max;
    }

    //方法二：按照数组特点
    public int FindGreatestSumOfSubArray1(int[] array) {
        if(array.length<=0) return 0;
        int maxOfAllSubArray=array[0];
        int cal=array[0];
        for(int i=1;i<array.length;i++){
            if(cal>=0){  //认为有贡献
                cal+=array[i];
            }else{
                cal=array[i];
            }
            if(cal>maxOfAllSubArray){
                maxOfAllSubArray=cal;
            }
        }
        return maxOfAllSubArray;
    }

    //方法三：动态规划
    public int FindGreatestSumOfSubArray2(int[] array) {
        if(array.length<=0) return 0;
        int maxOfAllSubArray=array[0];
        int cal=array[0];
        for(int i=1;i<array.length;i++){
            cal=Math.max(cal+array[i],array[i]);
            maxOfAllSubArray=Math.max(cal,maxOfAllSubArray);
        }
        return maxOfAllSubArray;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={-2,-8,-1,-5,-9};
        System.out.println(s.FindGreatestSumOfSubArray2(a));
    }
}
