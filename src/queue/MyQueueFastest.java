package queue;

import java.util.Stack;

/**
 * @author ljj
 * @version sprint 39
 * @className MyQueueFastest
 * @description
 * @date 2021-03-11 17:01:33
 */
public class MyQueueFastest {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyQueueFastest() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    /**
     * 可以先不倒回去，因为这部分可以保留下来，s1不一定非得是完全数据的状态
     */
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
