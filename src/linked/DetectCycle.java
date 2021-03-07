package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 环路检测
 *
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *  
 *
 * 进阶：
 *
 * 你是否可以不用额外空间解决此题？
 *
 */
public class DetectCycle {
    /**
     * 自己的版本1
     * 解题思路:利用set进行辅助，每遍历一个对象就存储在set中，如果
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if (!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 双指针版本，涉及数学推倒
     * 解题思路：定义快慢指针，其中快指针走的距离比慢指针多1。然后如果链表有环，则它们肯定会相遇。从相遇点到入环点的距离为从head到相遇点的距离。具体数学证明如下所示：
     * 我们使用两个指针，\textit{fast}fast 与 \textit{slow}slow。它们起始都位于链表的头部。随后，\textit{slow}slow 指针每次向后移动一个位置，而 \textit{fast}fast 指针向后移动两个位置。如果链表中存在环，则 \textit{fast}fast 指针最终将再次与 \textit{slow}slow 指针在环中相遇。
     *
     * 如下图所示，设链表中环外部分的长度为 aa。\textit{slow}slow 指针进入环后，又走了 bb 的距离与 \textit{fast}fast 相遇。此时，\textit{fast}fast 指针已经走完了环的 nn 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nc。
     *
     *任意时刻，\textit{fast}fast 指针走过的距离都为 \textit{slow}slow 指针的 22 倍。因此，我们有
     *
     * a+(n+1)b+nc=2(a+b) \implies a=c+(n-1)(b+c)
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     *
     * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     *
     * 因此，当发现 \textit{slow}slow 与 \textit{fast}fast 相遇时，我们再额外使用一个指针 \textit{ptr}ptr。起始，它指向链表头部；随后，它和 \textit{slow}slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * 时间复杂度：O(N)O(N)，其中 NN 为链表中节点的数目。在最初判断快慢指针是否相遇时，\textit{slow}slow 指针走过的距离不会超过链表的总长度；随后寻找入环点时，走过的距离也不会超过链表的总长度。因此，总的执行时间为 O(N)+O(N)=O(N)O(N)+O(N)=O(N)。
     *
     * 空间复杂度：O(1)O(1)。我们只使用了 \textit{slow}, \textit{fast}, \textit{ptr}slow,fast,ptr 三个指针。
     *
     */
    public ListNode detectCycleByDoublePointer(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            //如果fast和slow能相遇，说明肯定有环
            if (fast == slow) {
                ListNode ptr = head;
                //slow指针会走完n-1圈，然后再走到入环点，就会和ptr指针相遇
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
