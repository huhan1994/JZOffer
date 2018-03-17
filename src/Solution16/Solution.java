package Solution16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
    public ArrayList<String> result= new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str!=null &&str.length()>0){
            PermutationHelper(str.toCharArray(),0);
        }
        Collections.sort(result);
        return result;
    }

    public void PermutationHelper(char[] res,int i){
        if(i==res.length-1){
            String val=String.valueOf(res);
            result.add(val);

        }else{
            for(int j=i;j<res.length;j++){
                if(res[i]!=res[j]) {
                    swap(res, i, j);
                    PermutationHelper(res, i + 1);
                    swap(res, i, j);
                }
            }
        }
    }

    public void swap(char[] res,int i,int j){
        char temp=res[i];
        res[i]=res[j];
        res[j]=temp;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        String str="aa";
        s.Permutation(str);

    }
}
