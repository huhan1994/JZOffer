package Solution31;
//汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
// 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
// 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

public class Solution {
    //方法一：分别保存左移的数
    public String LeftRotateString(String str,int n) {
        int len=str.length();
        if(len<=0)  return null;
        int leftnum=n%len;
        if(leftnum==0){
            return str;
        }else {
            char[] chars = str.toCharArray();
            char[] temp=new char[leftnum];
            for(int i=0;i<leftnum;i++){
                temp[i]=chars[i];
            }
            for(int i=0;i<len-leftnum;i++){
                chars[i]=chars[i+leftnum];
            }
            for(int i=0;i<leftnum;i++){
                chars[i+len-leftnum]=temp[i];
            }
            return String.valueOf(chars);
        }
    }
    //把字符串按照左移的位数分为两部分，分别对两部分进行翻转，最后在对整个字符串进行翻转
    public String LeftRotateString1(String str,int n) {
        if(str==null||str.length()<=0)   return str;
        char[] chars=str.toCharArray();
        int leftnum=n%str.length();
        int P1start=0,P1end=leftnum-1;
        int P2start=leftnum,P2end=str.length()-1;
        reverse(chars,P1start,P1end);
        reverse(chars,P2start,P2end);
        reverse(chars,P1start,P2end);
        return String.valueOf(chars);
    }
    private void reverse(char[] chars,int begin,int end){
        while(begin<end){
            char temp=chars[begin];
            chars[begin]=chars[end];
            chars[end]=temp;
            begin++;
            end--;
        }
    }
}
