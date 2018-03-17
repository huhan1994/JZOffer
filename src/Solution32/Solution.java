package Solution32;
//牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
// 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
public class Solution {
    //算法思想：先翻转整个句子，然后，依次翻转每个单词。
    //依据空格来确定单词的起始和终止位置
    public String ReverseSentence(String str) {
        char[] chars=str.toCharArray();
        reverse(chars,0,chars.length-1);
        int preblank=-1;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==' '){
                int nextblank=i;
                reverse(chars,preblank+1,nextblank-1);
                preblank=nextblank;
            }
        }
        //处理最后一个单词
        reverse(chars,preblank+1,chars.length-1);
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

    //使用split(）函数切分
    public String ReverseSentence1(String str) {
        if(str==null||str.trim().equals("")) return str;
        String[] arr=str.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(reverseAndreturn(arr[i].toCharArray(),0,arr[i].length()-1));
            sb.append(" ");
        }
        //去除最后一个空
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        //翻转整个句子
        return reverseAndreturn(sb.toString().toCharArray(),0,sb.length()-1);
    }

    private String reverseAndreturn(char[] chars,int begin,int end){
        while(begin<end){
            char temp=chars[begin];
            chars[begin]=chars[end];
            chars[end]=temp;
            begin++;
            end--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        String s1=" ";
        System.out.println(s.ReverseSentence1(s1));
    }
}
