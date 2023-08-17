package linked;

/**
 * 判断链表是否存在环
 */
public class HasCycle {
    /**
     * 利用快慢指针进行判断，如果有环，则快指针肯定会追上慢指针，没环，则快指针会首先为null
     */
    public boolean hasCycleMy(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针优雅版
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
