package queue;

import java.util.Stack;

/**
 * @author ljj
 * @version sprint 39
 * @className MyQueue
 * @description
 * 化栈为队
 *实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @date 2021-03-11 16:41:13
 */
public class MyQueue {
    /**
     * 解题思路：
     * 因为需要模仿队列，所以说明需要实现的是先进先出的一个数据结构。然后题目上要求使用两个栈实现，那么就应该是一个栈用于存值，另外个栈用于操作时存储临时数据。
     * 解题步骤：
     * 1.定义两个栈，一个存数据，一个存出栈时的临时数据
     * 2.队列push时，就直接入栈即可
     * 3.出栈时，需要把一个栈的数据都出栈，然后放入另外一个栈，然后再出栈另外一个栈的栈顶元素即可。出栈完成需要还原数据
     * 4.peek和pop类似，只不过不用有删除元素的操作
     * 5.empty就判断第一个栈是否为null就行
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //先把stack1的数据倒到stack2
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result= stack2.pop();
        //再还原数据
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        //先把stack1的数据倒到stack2
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        //再还原数据
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}
