package Solution20;

import java.util.Arrays;
import java.util.Comparator;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0 || numbers==null)  return "";
        int len=numbers.length;
        String[] str=new String[len];
        for(int i=0;i<len;i++){
            str[i]=String.valueOf(numbers[i]);
        }
        StringBuilder sb=new StringBuilder();
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1=o1+o2;
                String c2=o2+o1;
                return c1.compareTo(c2);  //参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止，返回该不同的字符的asc码差值
            }
        });
        for(int i=0;i<len;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={3,5,1,4,2};
        System.out.println(s.PrintMinNumber(a));
    }
}
