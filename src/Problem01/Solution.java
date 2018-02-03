package Problem01;

//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

import java.util.Stack;

public class Solution {
    Stack<Integer> stack_data = new Stack<Integer>();
    Stack<Integer> stack_min = new Stack<Integer>();
    Integer temp = null; //temp记录stack_min当前栈顶元素
    public void push(int node) {
        if(temp==null){
            temp=node;
            stack_data.push(node);
            stack_min.push(node);
        }else {
            stack_data.push(node);
            if(node<=temp){
                temp=node;
                stack_min.push(node);
            }
        }
    }

    public void pop() {
        int num=stack_data.pop();
        int num1=stack_min.pop();
        if(num!=num1){
            stack_min.push(num1);
        }
    }

    public int top() {
        int num=stack_data.pop();
        stack_data.push(num);
        return num;
    }

    public int min() {
        int num1=stack_min.pop();
        stack_min.push(num1);
        return num1;
    }

}
