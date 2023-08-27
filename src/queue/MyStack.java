package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈 具体思路：
 * 为了满足栈的特性，即最后入栈的元素最先出栈，在使用队列实现栈时，应满足队列前端的元素是最后入栈的元素。可以使用两个队列实现栈的操作，其中 queue1\textit{queue}_1queue
 * 1
 * ​
 *   用于存储栈内的元素，queue2\textit{queue}_2queue
 * 2
 * ​
 *   作为入栈操作的辅助队列。
 *
 * 入栈操作时，首先将元素入队到 queue2\textit{queue}_2queue
 * 2
 * ​
 *  ，然后将 queue1\textit{queue}_1queue
 * 1
 * ​
 *   的全部元素依次出队并入队到 queue2\textit{queue}_2queue
 * 2
 * ​
 *  ，此时 queue2\textit{queue}_2queue
 * 2
 * ​
 *   的前端的元素即为新入栈的元素，再将 queue1\textit{queue}_1queue
 * 1
 * ​
 *   和 queue2\textit{queue}_2queue
 * 2
 * ​
 *   互换，则 queue1\textit{queue}_1queue
 * 1
 * ​
 *   的元素即为栈内的元素，queue1\textit{queue}_1queue
 * 1
 * ​
 *   的前端和后端分别对应栈顶和栈底。
 *
 * 由于每次入栈操作都确保 queue1\textit{queue}_1queue
 * 1
 * ​
 *   的前端元素为栈顶元素，因此出栈操作和获得栈顶元素操作都可以简单实现。出栈操作只需要移除 queue1\textit{queue}_1queue
 * 1
 * ​
 *   的前端元素并返回即可，获得栈顶元素操作只需要获得 queue1\textit{queue}_1queue
 * 1
 * ​
 *   的前端元素并返回即可（不移除元素）。
 *
 * 由于 queue1\textit{queue}_1queue
 * 1
 * ​
 *   用于存储栈内的元素，判断栈是否为空时，只需要判断 queue1\textit{queue}_1queue
 * 1
 * ​
 *   是否为空即可
 *   说白了就是要注意数据结构的特性
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
