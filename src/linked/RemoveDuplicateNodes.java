package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除链表中从重复元素，保留第一个出现的元素
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 */
public class RemoveDuplicateNodes {
    /**
     * 解题思路：
     * 考虑适用双指针+一个额外的Set的方式进行处理。指针用于进行元素比较，数组记录已经出现过的元素值。
     * 具体步骤：
     * 1.定义两个ListNode对象：fastNode，slowNode，分别引用head节点。定义一个Set。
     * 2.对链表进行遍历，然后fastNode向后移动，直到fastNode的val和slowNode不一样。
     * 3.判断set中是否存在fastNode的值，如果不存在就把值放入set然后让head的next指向slowNode。
     * 4.同步fastNode和slowNode。
     * 5.重复1,2,3,4直到链表遍历完成
     * 思路不对，这样出来的引用有问题
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head==null)return null;
        Set<Integer> numSet = new HashSet<>();
        numSet.add(head.val);
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        while (fastNode!=null){
            if (!numSet.contains(fastNode.val)){
                numSet.add(fastNode.val);
                slowNode.next = fastNode;
                slowNode = fastNode;
            }
            fastNode = fastNode.next;
        }
        //清空不需要的节点，这一步很关键。slowNode到哪，哪其实就是新链表的最后一位了，这一步一开始没有考虑到
        slowNode.next = null;
        return head;
    }

    /**
     * 最快的版本，耗时为1ms，时间复杂度为O(n)
     * 解题思路：
     * 采用的是数组比较的方式，因为题上说明了数字的范围是[0,20000]。所以我们可以定义数组来表示某个数字是否出现过（常用操作，数组来标记字符是否出现）。如果出现过，就把该位置为1。然后再进行重复性判断时，就只需要判断数字对应的位是否为1即可。为1就是存在，就直接删除该元素即可。
     * 具体步骤：
     * 1.定义前驱节点和当前节点，前驱节点是为了删除节点使用，前驱节点永远指向新节点的第一个值
     * 2.定义一个数组，用来保存数字是否出现
     * 3.开始遍历链表，判断元素的值是否在数组中存在，如果存在则跳过当前元素（说明重复），如果不存在，则更新数组值，并把该节点设为前驱节点的下一个节点，并设置前驱节点为该节点。
     * 4.一直遍历，直到链表遍历完毕（next为null时）。然后把前驱节点的next更新为null。相当于舍弃前驱节点指向节点以后的所有节点。
     */
    public static ListNode removeDuplicateNodesFastest(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        byte[] exsit = new byte[20000];
        exsit[head.val] = 1;
        while(cur != null){
            if(exsit[cur.val] == 0){
                pre.next = cur;
                pre = cur;
                exsit[cur.val] = 1;
            }
            cur = cur.next;
        }
        pre.next = cur;
        return head;
    }

    /**
     * 使用空间最小的版本，也是满足进阶的不使用临时缓冲区的版本。但是实际复杂度为O(n^2)。
     * 解题思路分析：
     * 采用双指针法。也就是定义了两个指针，一个固定指向需要比较的元素，一个往后不断往后移动。然后把和比较元素值一样的节点都直接删掉（cur.next = cur.next.next）。其中node为需要比较的节点的指针，cur是移动的指针。
     */
    public static ListNode removeDuplicateNodesSmallest(ListNode head) {
        ListNode shead = new ListNode(-1);
        shead.next = head;
        ListNode node = shead;
        while(node.next != null){
            ListNode cur = node.next;
            while(cur.next != null){
                if(cur.next.val == node.next.val){
                    cur.next = cur.next.next;

                }else{
                    cur = cur.next;
                }
            }
            node = node.next;
        }
        return shead.next;
    }




    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head = removeDuplicateNodes(head);
        ListNode next = head.next;
        System.out.println(head.val);
        while (next!=null){
            System.out.println(next.val);
            next = next.next;
        }
    }
}



