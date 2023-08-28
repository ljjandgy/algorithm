package linked;

/**
 * 删除链表中的给定元素
 *
 */
public class RemoveElements {
    /**
     * 我的解题方法
     * 核心思路还是遍历整个链表，然后断链删除节点
     * 1、定义一个返回用的结果指针，指向第一个不删除的节点，用于返回
     * 2、通过判断链表的下一个节点是否需要删除，如果需要删除，则断链
     * 3、一直循环到最后个节点，然后返回一开始定义的结果指针即可
     */
    public ListNode removeElementsMy(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode resultHead = null;
        //排除开头的值
        while(head !=null && head.val == val){
            head = head.next;
        }
        resultHead = head;
        while(head!=null){
            ListNode next = head.next;
            if(next!=null && next.val ==val){
                head.next = next.next;
            }else{
                head = head.next;
            }

        }
        return resultHead;
    }

    /**
     * 递归的方式进行删除，具体思路为
     * 不断往后压栈，如果当前节点需要删除，就返回下一个节点，否则返回自己，然后再回溯的时候上一个节点拼上返回的节点即可
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
