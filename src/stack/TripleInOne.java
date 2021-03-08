package stack;

/**
 * @author ljj
 * @version sprint 39
 * @className TripleInOne
 * @description
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * @date 2021-03-08 14:07:15
 */
public class TripleInOne {
    private int stackSize;

    private Integer[] array;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        array = new Integer[3*stackSize];
    }

    /**
     * 入栈
     * @param stackNum 操作第几个栈
     * @param value 入栈的值
     */
    public void push(int stackNum, int value) {
        if(array.length>1&&array[stackNum*stackSize]==null){
            for(int i=(stackNum+1)*stackSize-1;i>=(stackNum*stackSize);--i){
                if (array[i]==null){
                    array[i] = value;
                    break;
                }
            }
        }
    }

    /**
     * 出栈
     * @param stackNum 栈编号
     * @return 栈元素
     */
    public int pop(int stackNum) {
        //栈不为空才取值
        if (array.length>1&&array[(stackNum+1)*stackSize-1]!=null){
            for(int i=stackNum*stackSize;i<(stackNum+1)*stackSize;++i){
                if (array[i]!=null){
                    int tmp = array[i];
                    array[i] = null;
                    return tmp;
                }
            }
        }
        return -1;
    }

    /**
     * 查看栈最后一个元素
     * @param stackNum 栈编号
     * @return
     */
    public int peek(int stackNum) {
        //栈不为空才取值
        if (array.length>1&&array[(stackNum+1)*stackSize-1]!=null){
            for(int i=stackNum*stackSize;i<(stackNum+1)*stackSize;++i){
                if (array[i]!=null){
                    return array[i];
                }
            }
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return array.length==0||array[(stackNum+1)*stackSize-1]==null;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(0);
        System.out.println(tripleInOne.isEmpty(2));
        System.out.println(tripleInOne.pop(1));
        System.out.println(tripleInOne.peek(0));
        tripleInOne.push(0,10);
    }
}
