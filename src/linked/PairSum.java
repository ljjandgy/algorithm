package linked;

/**
 * 最大孪生和
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 *
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 *
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 */
public class PairSum {
    /**
     * 解题方法：快慢指针+翻转链表
     * 解题思路：
     * 从题中可知，所谓孪生节点就是轴对称节点，求最大和，就是就轴对称节点的最大和。
     * 因为题目是单向链表，所以需要翻转一半的链表，才能事项循环求孪生和
     * 所以先利用快慢指针找到链表中点，然后翻转后半链表，最后再遍历求和，并求出最大值
     */
    public int pairSum(ListNode head) {
        //翻转后半链表
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        int max = 0;
        while(prev!=null){
            max = Math.max(max,prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }
        return max;
    }
}
