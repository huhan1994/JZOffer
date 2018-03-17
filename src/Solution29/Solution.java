package Solution29;

import java.util.ArrayList;
import java.util.Arrays;

//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
// 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
// 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(sum<=0)  return arrayLists;
        int small=1;
        int big=2;
        int maxsmall=(sum-1)/2; //small的最大取值
        int mysum;
        while((small<big)&&(small<=maxsmall)){
            mysum=getsum(small,big); //求small和big之前数之和
            if(sum==mysum){
                arrayLists.add(writeToArray(small,big));
                small++;
                big++;
            }else if(mysum<sum){
                big++;
            }else{
                small++;
            }
        }
        return arrayLists;
    }

    private ArrayList<Integer> writeToArray(int start,int end){
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=start;i<=end;i++){
            arrayList.add(i);
        }
        return arrayList;
    }

    //求start和end之间数之和
    private int getsum(int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        ArrayList<ArrayList<Integer>> arrayLists=s.FindContinuousSequence(100);
        for(int i=0;i<arrayLists.size();i++){
            System.out.println(Arrays.toString(arrayLists.get(i).toArray()));
        }
    }
}
