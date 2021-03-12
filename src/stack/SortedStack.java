package stack;

import java.util.Stack;

public class SortedStack {

    /**
     * 思路分析：因为运行用一个临时栈进行数据保存。说明排序的时候就可以借助这个栈来实现。
     * 具体步骤:
     * 1.入栈：如果比栈顶元素小，直接入栈。如果比栈顶元素大，就先把栈顶元素放入另外个栈，直到找到比它大的元     * 素。然后把临时栈的数据返回
     * 2.出栈：直接出栈即可
     * 3.peek：返回栈顶指针
     * 需要额外注意栈空的情况.还需要注意当进入的值比所有值都大的情况
     **/
    private Stack<Integer> stack1;
    /** 临时栈 **/
    private Stack<Integer> stack2;
    public SortedStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if(isEmpty()){
            stack1.push(val);
        }else if(val<=stack1.peek()){
            stack1.push(val);
        }else{
            while(!isEmpty()){
                stack2.push(stack1.pop());
                if(isEmpty()||stack1.peek()>=val){
                    stack1.push(val);
                    break;
                }
            }
            //数据还原
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public void pop() {
        if(!isEmpty()){
            stack1.pop();
        }

    }

    public int peek() {
        if(isEmpty()){
            return -1;
        }
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
