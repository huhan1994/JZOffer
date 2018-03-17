import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {
    //方法一：hashmap(O(n))
    public int  MoreThanHalfNum_Solution1(int [] array){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                int count=map.get(array[i]);
                map.put(array[i],++count);
            }
            int time=map.get(array[i]);
            if(time>array.length>>1)
                return array[i];
        }
//        Iterator iter=map.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry entry=(Map.Entry)iter.next();
//            Integer key=(Integer)entry.getKey();
//            Integer value=(Integer)entry.getValue();
//            if(value>array.length/2)
//                return key;
//        }
        return 0;
    }

    //方法二：基于数组特点
    public int  MoreThanHalfNum_Solution2(int [] array){
        if(array.length<=0)  return 0;
        int result=array[0];
        int count=1;
        for(int i=1;i<array.length;i++){
            if(array[i]==result){
                count++;
            }else{
                count--;
            }
            if(count==0){
                result=array[i];
                count=1;
            }
        }
        int time=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result){
                time++;
            }
        }
        if(time>array.length/2){
            return result;
        }else{
            return 0;
        }
    }

    // 基于快速排序
    // 这种算法是受快速排序算法的启发。在随机快速排序算法中，我们现在数组中随机选择一个数字，然后调整数组中数字的顺序，使得比选中的数字小的数字都排在它的左边，比选中的数字大的数字都排在它的右边。
    // 如果这个选中的数字的下标刚好是n/2，那么这个数字就是数组的中位数。如果它的下标大于n/2，那么中位数应该位于它的左边，我们可以接着在它的左边部分的数组中查找。
    // 如果它的下标小于n/2，那么中位数应该位于它的右边，我们可以接着在它的右边部分的数组中查找。
    // 目的是找到位于n/2的点
    // 这是一个典型的递归过程

    public int  MoreThanHalfNum_Solution3(int [] array) {
        if(array.length<=0)     return 0;
        int low=0;
        int high=array.length-1;
        int middle=array.length>>1;
        int privoIndex=partition(array,low,high);
        while(privoIndex!=middle){
            if(privoIndex<middle){
                privoIndex=partition(array,privoIndex+1,high);
            }else{
                privoIndex=partition(array,low,privoIndex-1);
            }
        }
        int result=array[middle];
        int time=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result){
                ++time;
            }
        }
        if(time>array.length>>1)
            return result;
        else
            return 0;
    }

    public int partition(int[] a,int low,int high){
        int privokey=a[low];
        while(low<high){
            while(low<high && a[high]>=privokey)
                --high;
            swap(a,low,high);
            while(low<high && a[low]<=privokey)
                ++low;
            swap(a,low,high);
        }
        return low;
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        test t=new test();
        int[] array={1,3,5,6,5,7,5,5,3,5,5};
        System.out.println(t.MoreThanHalfNum_Solution1(array));
    }
}