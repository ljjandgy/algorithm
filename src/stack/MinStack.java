package stack;

import linked.ListNode;

import java.util.Stack;

/**
 * @author ljj
 * @version sprint 39
 * @className MinStack
 * @description 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 下面是链表方式实现的，核心思想是每个节点都记录以自己为栈顶时，栈最小值的情况。
 * 也可以考虑使用双栈的形式实现，具体操作为定义一个基本栈和一个最小栈，在入普通栈时，判断入栈的值是否小于等于最小栈的栈顶元素（最小栈为空就直接入栈即可），如果满足，就入栈。出栈时如果值和最小栈栈顶值一样，最小栈同时出栈。取最小值，就返回最小栈的栈顶指针即可。
 * @date 2021-03-09 15:12:37
 */
public class MinStack {
    private ListNode head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head==null){
            //初始化栈顶指针
            head = new ListNode(x,null,x);
        }else {
            //栈顶指针后移
            head = new ListNode(x,head,Math.min(head.min,x));
        }
    }

    public void pop() {
        if (head!=null){
            head = head.prev;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class ListNode {
        int val;
        ListNode prev;
        /** 以当前节点为栈顶时栈的最小值。一开始想记录第二小的节点信息，后来发现不遍历不行 **/
        int min;


        ListNode(int x,ListNode prev,int min) {
            val = x;
            this.prev = prev;
            this.min = min;
        }
    }
}
