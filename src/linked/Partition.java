package linked;

/**
 * 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 */
public class Partition {
    /**
     * 自己的版本
     * 解题思路：
     * 因为要根据x分割链表，所以肯定需要遍历整个链表。我们定义一个指针专门遍历链表。第一次遍历找出原链表中第一个小于x的节点作为新链表的头结点。然后再对原链表进行遍历，遍历过程中把小于x的拼接到新链表中，然后在原链表中删除，遍历完成后，新链表拼接上剩下的原链表就是最终的链表。
     * 具体步骤：
     * 1.遍历找到第一个小于x的节点作为新链表头结点
     * 2.再次遍历原链表，把小于x的拼接到新链表，并从原链表中删除。大于等于x的留在原链表中
     * 3.拼接新链表和原链表并返回
     *  思路过于复杂，不容易进行重复节点排查的判断，而且删除操作比较复杂，需要维护额外的指针
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head.next==null)return head;
        ListNode newHead = head;
        while (newHead!=null&&newHead.val>=x){
            newHead = newHead.next;
        }
        if (newHead==null){
            return head;
        }
        newHead.next = null;
        ListNode p = head;
        while (p!=null){
            if (p.val<x){
                newHead.next = p;
                p.next = null;
                newHead = p;
            }else{

            }
            p = p.next;
        }
        return null;
    }

    /**
     * 双指针+双链表法（两对双指针实现。其中任意一对的快指针都是用于添加链表，慢指针永远指向头部）
     * 解题思路：
     * 一个链表用于保存小于x的元素，一个链表保存大于等于x的元素。
     * 然后双指针一个指向小于x链表的头部，一个指向大于等于x元素链表的头部。第一个指针用于拼接后的返回，第二个指针用于拼接
     * 最后用第一个链表拼接第二个链表就是最终的结果。
     *
     */
    public ListNode partitionByDoubleDoublePointer(ListNode head, int x){
        ListNode lessP = new ListNode(-1);
        ListNode moreP = new ListNode(-1);
        ListNode less =lessP;
        ListNode more = moreP;
        ListNode tmp = head;
        while (tmp!=null){
            //保存当前tmp在原链表中的下个节点，很关键，不然无法继续遍历，不然就需要在最后对less和more的next置为null
            ListNode nextTmp = tmp.next;
            if (tmp.val<x){
                less.next = tmp;
                tmp.next = null;
                less = tmp;
            }else{
                more.next = tmp;
                tmp.next = null;
                more = tmp;
            }
            tmp = nextTmp;
        }
        less.next = moreP.next;
        return lessP.next;
    }

    /**
     * 真双指针法
     * 解题思路：
     * 定义两个指针，慢指针指向未被交换的节点，快指针去寻找比x小的节点。一旦发现比x小的节点，就把值和慢指针指向的元素交换。对于链表来说，交换值就和交换对象效果一样的。
     * @return
     */
    public ListNode partitionByDoublePointer(ListNode head, int x){
        ListNode less = head;
        ListNode more = head;
        while (more!=null){
            if (more.val<x){
                int tmp = less.val;
                less.val = more.val;
                more.val = tmp;
                less = less.next;
            }
            more = more.next;
        }
        return head;
    }
}
