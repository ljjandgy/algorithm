package linked;

/**
 * 链表相交
 *
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 *
 *
 * 示例 1：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例 3：
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null 。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 */
public class GetIntersectionNode {
    /**
     * 自己的版本
     * 解题思路：如果两个链表一样，则可以直接通过遍历，比较链表中有没有地址一样的对象即可。如果是长度不一样，就让长链表先移动n-m次，然后再和短链表一起遍历，判断有没有地址一样的对象即可。
     * 解题步骤：
     * 1.定义两个变量，分别用于记录链表a和链表b的长度
     * 2.通过遍历链表A和链表B，获取链表长度
     * 3.如果长度一样，就直接遍历，对比对象地址即可。
     * 4.如果长度不一样，就先移动长链表，没移动一次，链表长度-1。当链表长度一致时，重复第3步操作
     * 时间复杂度：O(n+m)
     * @return 相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==headB){
            return headA;
        }
        int aLength = 0;
        int bLength = 0;
        ListNode curA = headA;
        while (curA!=null){
            ++aLength;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB!=null){
            ++bLength;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (aLength==bLength){
            while (curA!=null){
                if (curA==curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }else if(aLength>bLength){
            while (aLength>bLength){
                curA = curA.next;
                --aLength;
            }
            while (curA!=null){
                if (curA==curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }else{
            while (bLength>aLength){
                curB = curB.next;
                --bLength;
            }
            while (curA!=null){
                if (curA==curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
    /**
     * 双指针版本，就是说如果一个链表遍历完了就去遍历另外一个链表。其实这个操作和上面操作是类似的，因为走完自己去走别人就是让第二次遍历时，能让更长链表的遍历和长度和长度小的链表一致。
     * 这个方法相当于是把上面的三种情况合在一起了，很牛逼的想法。需要通过画图才能想的出来
     * 因为需要把两个链表都遍历一遍
     * 时间复杂度为O(m+n)
     */
    public ListNode getIntersectionNodeByDoublePointer(ListNode headA, ListNode headB) {
        if (headA==headB){
            return headA;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=curB){
            //自己遍历完了就去遍历别人，这样做就是为了对齐链表。链表不对齐的部分不可能相交，因为另外个链表还没出现
            curA = curA==null?curA=headB:curA.next;
            curB = curB==null?curB=headA:curB.next;
        }
        return curA;
    }
}
