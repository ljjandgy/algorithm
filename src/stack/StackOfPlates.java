package stack;

/**
 * @author ljj
 * @version sprint 39
 * @className StackOfPlates
 * @description 堆盘子
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 *
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 *
 * 示例1:
 *
 *  输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 *  输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 *
 *  输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, 3]
 *
 *
 * @date 2021-03-10 14:33:30
 */
public class StackOfPlates {
    //默认设置最大支持200个栈
    private ListNode[] listNodes;
    private ListNode head;
    private int[] numArray;
    private int stackSize;
    //当前栈的序号
    private int num=0;
    /**
     * 思路分析：
     * 核心在于popAt方法，也就是需要快速的找到对应编号的栈信息以及栈的分割。需要注意的是由于会从中间进行删除，所以不适合使用数组来作为栈
     * 针对上面的注意点，具体思路如下：
     * 采用链表实现栈，每隔cap个对象，设置一个栈顶节点，这些栈顶节点可以用一个数组保存起来，就类似于一个map了。
     * @param cap 每个栈的容量
     */
    public StackOfPlates(int cap) {
        listNodes = new ListNode[200];
        //记录每个栈的记录数
        numArray = new int[200];
        //定义head节点,没有实际意义，专门用于指向栈顶的下一个个节点，用于操作栈顶节点
        head = new ListNode(-1,null,null);
        stackSize = cap;
    }

    public void push(int val) {
        head.next = new ListNode(val,head.next,head);
        if (numArray[num]>=stackSize){
            ++num;
        }
        listNodes[num]=head.next;
        numArray[num]++;

    }

    public int pop() {
        if (head.next!=null){
            ListNode tmp = head.next;
            head.next = head.next.next;
            //栈为空时，需要删除栈，并且栈指针-1
            if (--numArray[num]==0){
                listNodes[num--] = null;
            }
            return tmp.val;
        }
        return -1;
    }

    /**
     * 取特定栈的栈顶元素。
     * 具体步骤：
     * 1.判断栈是否存在，不存在就返回-1
     * 2.栈存在时，就记录栈顶节点信息，然后删除栈顶节点。如果此时当前栈所有元素都出栈了，需要把后面的栈向前移动一位。
     * 3.栈整体数量-1
     * @param index
     * @return
     */
    public int popAt(int index) {
        if (isEmptyOrNotExist(index)){
            return -1;
        }
        int tmpVal = listNodes[index].val;
        listNodes[index].pre.next = listNodes[index].next;
        if (--numArray[num]==0){
            while (listNodes!=)
        }
        return tmpVal;
    }

    private boolean isEmptyOrNotExist(int stackNum){
        return listNodes[stackNum]==null;
    }

    /**
     * 该用双向链表时
     */
    class ListNode{
        int val;
        ListNode pre;
        ListNode next;

        ListNode(int val,ListNode next,ListNode pre){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(1);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.popAt(1);
        stackOfPlates.pop();
        stackOfPlates.pop();
    }
}
