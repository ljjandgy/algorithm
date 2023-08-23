package linked;

/**
 * 反转链表
 */
public class ReverseList {
    /**
     * 循环方式
     * 通过设置prev指针指向某个节点的上一个节点，设置curr指针指向当前节点，设置next临时指针指向下个节点，然后通过更换当前节点的next指针来实现链表反转
     */
    public ListNode reverseListForeach(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 通过递归实现链表反转
     * 核心思想是通过递归方法帧中的head信息来记录当前节点的信息
     * @param head
     * @return
     */
    public ListNode reverseListLoop(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //newHead一直指向的是尾部节点，没有变过
        ListNode newHead = reverseListLoop(head.next);
        //第一次回溯时，head是倒数第二个节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
