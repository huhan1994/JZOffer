package Solution28;

import java.util.*;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length<=0|| array==null)   return;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int count=map.get(array[i]);
                map.put(array[i],++count);
            }else{
                map.put(array[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        num1[0]=list.get(0).getKey();
        num2[0]=list.get(1).getKey();
    }

    //利用异或的性质，任何一个数异或它自己都为0；0与任何一个数异或都为原数字。
    //出现两次的数都被抵消掉，根据数组异或的结果求得第一个为1的下标，记为第n位。为1表示除了抵消掉的数之外，剩余的两个数在该位上不同，否则相同的话异或结果位0；
    //按照第n位是否为1进行划分，得到两个数组，且相同数字的都划分到了一个组中，并且每个数组中都只包含一个只出现1次的数字。
    //分别对两数组进行异或，可以得到两个只出现1次的数字。
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int length=array.length;
        if(length<=0||array==null)  return;
        if(length==2){
            num1[0]=array[0];
            num2[0]=array[1];
            return;
        }
        int bitresult=0;
        //对数组中的数依次求异或
        for(int i=0;i<length;i++){
            bitresult^=array[i];
        }
        //找到异或运算结果第一个为1的位置
        int firstIndexIs1=findfirst1(bitresult);
        for(int i=0;i<length;i++){
            if(isBit1(array[i],firstIndexIs1)){
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];
            }
        }
    }

    private int findfirst1(int bitresult){
        int index=0;
        while((bitresult & 1)==0 && index<32){
            bitresult>>=1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target,int index){
        return ((target>>index)&1)==1;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] array={1,4,5,2,7,5,9,0,4,1,2,0};
        int[]num1=new int[1];
        int[]num2=new int[1];
        s.FindNumsAppearOnce1(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}

