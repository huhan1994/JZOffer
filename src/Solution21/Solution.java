package Solution21;

import java.util.Arrays;

//把只包含因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含因子7。
// 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class Solution {
    //解法一：逐一判断每个数是不是丑数
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int number=0;
        int uglyfound=0;
        while(uglyfound<index){
            ++number;
            if(isUglyNumber(number)){
                ++uglyfound;
            }
        }
        return number;
    }

    public boolean isUglyNumber(int number){
        while(number%2==0)
            number=number/2;
        while(number%3==0)
            number=number/3;
        while(number%5==0)
            number=number/5;
        return (number==1)?true:false;
    }

    //解法二：用数组存放丑数，利用空间换时间
    public int GetUglyNumber_Solution1(int index) {
        if(index<=0)    return 0;
        int[] uglyArray=new int[index];
        uglyArray[0]=1;
        int nextuglyIndex=1;
        int Index2=0;
        int Index3=0;
        int Index5=0;
        while(nextuglyIndex<index){
            uglyArray[nextuglyIndex]=minOf3number(2*uglyArray[Index2],3*uglyArray[Index3],5*uglyArray[Index5]);
            while(2* uglyArray[Index2]<=uglyArray[nextuglyIndex])
                Index2++;
            while (3*uglyArray[Index3]<=uglyArray[nextuglyIndex])
                Index3++;
            while(5*uglyArray[Index5]<=uglyArray[nextuglyIndex])
                Index5++;
            nextuglyIndex++;
        }
        return uglyArray[index-1];
    }

    public int minOf3number(int a,int b,int c){
        int min1=(a<b)?a:b;
        int min=(min1<c)?min1:c;
        return min;
    }
}
