package linked;

/**
 * @author ljj
 * @version sprint 38
 * @className KthToLast
 * @description 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 * @date 2021-03-01 10:22:24
 */
public class KthToLast {
    /**
     * 自己的版本
     * 解题思路：
     * 因为要取倒数第K个节点，说明需要返回的节点到最后一个节点中只能包含k个节点。也就是说当一个节点向后遍历k-1个节点还没有达到最后一个节点时，这个节点就不是我们要返回的节点。
     * 具体步骤：
     * 1.创建两个指针，一个慢指针指向待定需要返回的元素和一个快指针负责向后遍历。并添加一个计数器，记录遍历的次数。
     * 2.因为k是有效的，所以不用考虑没有倒数第k的元素的可能
     * 3.当移动到最后一位，并且次数等于k-1，则说明慢指针指向的就是我们要的数，然后返回
     * 4.k==1比较特殊，需要特殊处理（边界值的处理需要深思熟虑）
     */
    public static int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int num = 0;
        while (fast.next!=null){
            if (num==k-1&&k!=1){
                slow = slow.next;
                fast = slow;
                num=0;
            }
            fast = fast.next;
            ++num;
        }
        if (k==1){
            slow = fast;
        }
        return slow.val;
    }

    /**
     * 耗时最短的版本
     * 思路分析：
     * 因为要取倒数第k个元素，则先让原链表移动k-1次形成一个新链表，然后一新链表作为遍历的基准，然后再对原链表进行遍历，这样停止遍历时指针的位置就是倒数第k个元素。
     * 值得学习的点：
     * 1.有时候需要进行逆向思考，而不是总是正向处理问题。
     * 2.参照物可以由自身去生成，不一定非得新开辟空间进行处理
     */
    public int kthToLastFastest(ListNode head, int k) {
        ListNode ln=head;
        while(k-->0){
            ln=ln.next;
        }
        while(ln!=null){
            ln=ln.next;
            head=head.next;
        }
        return head.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(kthToLast(head, 1));
    }
}
