package Solution33;

import java.util.Arrays;

//LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
// 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
// “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
// 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
// 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
public class Solution {
    //1.把数组排序
    //2.统计数组中0的个数
    //3.统计排序之后的数组中相邻数字之间的空缺总数，如果空缺总数小于等于0的个数，则数组是连续的，否则是不连续的
    //4.注意：如果数组中非0数字重复出现，则肯定是不连续的
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<1||numbers==null){
            return false;
        }
        //Arrays.sort(numbers);
        quickSort(numbers,0,numbers.length-1);
        //统计数组中0的个数
        int count0=0;
        for(int i=0;i<numbers.length-1 && numbers[i]==0;i++)
            count0++;
        //统计数组中相邻数字之间的空缺总数
        int countGap=0;
        int low=count0;
        int high=low+1;
        while(high<numbers.length){
            if(numbers[low]==numbers[high]){  //数组中存在相邻两元素相同，则不可能为连续数组
                return false;
            }else{
                countGap+=numbers[high]-numbers[low]-1;
                low++;
                high++;
            }
        }
        return (count0>=countGap)?true:false;

    }

    private int partition(int[] a,int low,int high) {
        int privokey=a[low];
        while(low<high){
            while(low<high && a[high]>=privokey)
                high--;
            swap(a,low,high);
            while(low<high && a[low]<=privokey)
                low++;
            swap(a,low,high);
        }
        return low;
    }

    public void quickSort(int[] a,int low,int high){
        if(low<high){
            int privocLoc=partition(a,low,high);
            quickSort(a,low,privocLoc-1);
            quickSort(a,privocLoc+1,high);
        }
    }

    private void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
