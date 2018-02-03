package Problem04;

//请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

public class Solution {
    public String replaceSpace(StringBuffer str) {
        String replacement="%20";
        StringBuilder newString=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c==' '){
                newString.append(replacement);
            }else{
                newString.append(c);
            }
        }
        return newString.toString();
    }

//    public static void main(String[] args) {
//        Solution s=new Solution();
//        String s1="We Are Happy";
//        StringBuffer s2=new StringBuffer(s1);
//        System.out.println(s.replaceSpace(s2));
//    }
}
