package string;

import java.util.Stack;

/**
 * 给你一个包含若干星号 * 的字符串 s 。
 *
 * 在一步操作中，你可以：
 *
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 */
public class RemoveStars {
    /**
     * 解题方法：栈
     * 具体流程就是通过出入栈，删除字符
     * @param s
     * @return
     */
    public String removeStars(String s) {
        Stack<Character> deque=new Stack<>();
        int n=s.length();
        deque.push(s.charAt(0));
        int i=1;
        while(i<n){
            if(s.charAt(i)=='*'&&!s.isEmpty()){
                if(deque.peek()=='*')deque.push(s.charAt(i));
                else deque.pop();
            }else{
                deque.push(s.charAt(i));
            }
            i++;
        }

        String str = "";
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;

    }
}
