package Sort;

import java.util.Arrays;

public class HeapSort {
    //大根堆排序算法
    public void Heapsort(int[] array,int length){
        //初始堆
        BuildHeap(array,length);
        for(int i=length-1;i>=0;i--){
            //交换堆顶元素array[0]和堆中最后一个元素
            int temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            //交换之后，重新调整堆
            AdjustHeap(array,0,i);
        }
    }

    /**
    * 初始堆进行调整
    * 将H[0..length-1]建成堆
     * 调整完之后第一个元素是序列的最大的元素
    */
    public void BuildHeap(int[] array,int length){
        //(length-1)/2为最后一个有孩子结点的位置
        for(int i=(length-1)/2;i>=0;i--){
            AdjustHeap(array,i,length);
        }
    }

    //调整array[s],使其成为大顶堆.即将对第s个结点为根的子树筛选
    public void AdjustHeap(int[] array,int s,int length){
        int temp=array[s];
        int child=2*s+1; //左孩子结点位置
        while(child<length){
            //如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
            if(child+1<length && array[child+1]>array[child]){
                ++child;
            }
            if(array[s]<array[child]){
                array[s]=array[child];  //先把较大的子节点往上移，替换父结点
                array[child]=temp; //互换s和child元素
                s=child;  //重新调整s，即为待调整的下一节点
                child=s*2+1; //待调整新的s的左孩子结点
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        int[] array={32,43,23,13,5,19,34,42,10,4};
        heapSort.Heapsort(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
