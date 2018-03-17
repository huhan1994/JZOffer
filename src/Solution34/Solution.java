package Solution34;
// 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
// 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
// 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
// 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
// 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
//题目：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
public class Solution {
    //用数组来模拟环
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1)    return -1;
        int[] array=new int[n];
        int count=n; //剩余的数的个数
        int step=0; //报数的步骤
        int i=-1;//i:被删除掉的元素的下标
        while(count>0){
            i++; //指向上一个被删除的元素的下一个的位置
            if(i>=n)
                i=0;//模拟环
            if(array[i]==-1)
                continue; //跳过已被删除的元素
            step++;
            if(step==m){
                array[i]=-1;
                step=0;
                count--;
            }
        }
        return i; //返回的是最后一个
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.LastRemaining_Solution(5,3));
    }

}