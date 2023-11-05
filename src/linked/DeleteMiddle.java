package linked;

/**
 * 删除链表中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 *
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 *
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 */
public class DeleteMiddle {
    /**
     * 解题方法：双指针（快慢指针）
     * 解题思路：定义快指针和慢指针，其中快指针的移动速度是慢指针的两倍。这样当快指针到达链表尾部的时候，慢指针正好达到中心，正好是需要删除的节点
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //因为要删除节点，所以考虑维护一个pre指针，方便删除链表节点
        ListNode preNode = null;
        while(fast!=null&&fast.next!=null){
            preNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(preNode==null){
            return null;
        }else{
            preNode.next = slow.next;
        }
        return head;
    }
}
