package linked;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ljj
 * @version sprint 39
 * @className IsPalindrome
 * @description
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *  
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @date 2021-03-05 14:54:27
 */
public class IsPalindrome {
    /**
     * 自己的方式
     * 解题思路：
     * 利用栈来存储，然后把栈里面的数据和链表数据做比较，出现不一样说明不是回文链表
     * 解题步骤：
     * 1.定义一个栈
     * 2.遍历链表，把元素都放到栈中
     * 3.取出栈中的元素，然后和链表值做比较，出现不同就返回false
     * 4.遍历完都一样，返回true
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public boolean isPalindromeStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            if (stack.pop()!=cur.val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 效率最高的方法，双指针法（双指针果然万能，可惜现在的我想不出来）
     * 解题思路：反转后半部分链表，然后用后半部分链表和前半部分循环比较，如果都相同就返回true，如果出现不同就返回false。
     * 解题步骤：
     * 1.创建双指针，分别为快指针和慢指针。在寻找中间节点时，只需要慢指针移动一位，快指针移动两位即可。
     * 2.从中间节点开始反转链表
     * 3.用反转后的链表和原始链表进行比较，如果出现不同就返回false
     * 4.全部相同返回true
     */
    public static boolean isPalindromeDoublePointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!=null){
            slow = slow.next;
        }
        //此时slow就是中间节点,slow.next是需要反转的链表
        ListNode pre = null;
        while (slow!=null){
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        //判断链表内容是否一致
        fast = head;
        while (pre!=null&&fast!=null){
            if (fast.val!=pre.val){
                return false;
            }
            fast = fast.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {2,2,1};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i:array){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(isPalindromeDoublePointer(head));
    }
}
