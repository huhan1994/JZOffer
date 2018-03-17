package Solution22;

import java.util.*;

//在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str.length()<0||str==null)   return 0;
        HashMap<Character,Integer>  map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int count=map.get(str.charAt(i));
                map.put(str.charAt(i),++count);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        //按照str的顺序遍历一次，去hashmap中找到第一个count==1的值即可
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        String a="googgle";
        System.out.println(s.FirstNotRepeatingChar(a));
    }
}
