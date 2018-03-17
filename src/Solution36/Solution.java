package Solution36;
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Solution {
    //不能+、-、*、/，则能用于数字计算的只有位运算
    //1.先计算两数字不进位之和
    //2.计算进位的和
    //3.重复，直到第二步结果不进位即全为0，返回第一步数
    public int Add(int num1,int num2) {
        while(num2!=0){
            //记录不进位之和
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
}
