package linked;

/**
 * @author ljj
 * @version sprint 38
 * @className AddTwoNumbers
 * @description 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @date 2021-03-04 09:24:43
 */
public class AddTwoNumbers {
    /**
     * 自己的版本
     * 解题思路：同时遍历两个链表，然后挨着相加，如果加起来的数大于了10，那么就取小于-10之后的内容作为结果链表中的成员。然后记录下一位需要+1。然后然后结果链表即可。
     * 1.定义两个指针，用于遍历链表。定义一个新的链表，用于保存结果集。定义一个标志位，判断后一位是否需要加1。
     * 2.遍历链表，让两个链表的元素值相加，判断是否大于10，如果大于，则取个位部分，然后标志位置为true。如果小于，则保留原值直接添加到结果链表即可。遍历时需要考虑链表长度不一样的情况。所以当一个链表遍历完毕，就应该用0来填补剩下的位数。
     * 3.然后结果链表head节点的next
     *
     * 注意点：
     * 1.链表长度可以不一样
     * 2.结果链表长度可能比原链表多1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(-1);
        ListNode resultP = resultHead;
        ListNode l1P = l1;
        ListNode l2P = l2;
        boolean needAddOne = false;
        while (l1P!=null||l2P!=null){
            int l1Val = l1P==null?0:l1P.val;
            int l2Val = l2P==null?0:l2P.val;
            int sum = l1Val +l2Val;
            if (needAddOne){
                ++sum;
                needAddOne = false;
            }
            if (sum>=10){
                resultP.next = new ListNode(sum-10);
                needAddOne = true;
            }else{
                resultP.next = new ListNode(sum);
            }
            resultP = resultP.next;
            l1P = l1P==null?null:l1P.next;
            l2P = l2P==null?null:l2P.next;
        }
        if (needAddOne){
            resultP.next = new ListNode(1);
        }
        return resultHead.next;
    }

    /**
     * 代码简洁版本，思路和上面版本差不多，最大的区别在于进位的计算不再是通过标志位，而是直接通过数字进行操作，这样就会少很多判断的代码。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersClean(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(-1);
        ListNode resultP = resultHead;
        ListNode l1P = l1;
        ListNode l2P = l2;
        int tmp = 0;
        while (l1P!=null||l2P!=null){
            int l1Val = l1P==null?0:l1P.val;
            int l2Val = l2P==null?0:l2P.val;
            tmp += (l1Val +l2Val);
            resultP.next = new ListNode(tmp%10);
            resultP = resultP.next;
            l1P = l1P==null?null:l1P.next;
            l2P = l2P==null?null:l2P.next;
            //如果tmp比10大，说明原值相加再加上进位比10大，需要继续向后进位
            tmp = tmp/10;
        }
        if (tmp!=0){
            resultP.next = new ListNode(tmp);
        }
        return resultHead.next;
    }

    //如果是把链表反过来，我们就可以通过多维护一个结果链表的pre指针来让进位能加到上一位去。然后最后判断第一位是否为0，是0就说明最高位没有进位。就返回resultHead.next否则返回resultHead即可。
}
