package stack;

/**
 * @author ljj
 * @version sprint 39
 * @className TripleInOneFastest
 * @description
 * 判断栈满需要注意，不要忘了这个行为
 * @date 2021-03-08 15:15:17
 */
public class TripleInOneFastest {
    private int[] array;
    //维护了三个数组的尾指针，用于快速取值和放值
    private int[] idx = new int[3];
    private int stackSize;
    public TripleInOneFastest(int stackSize) {
        this.stackSize = stackSize;
        array = new int[stackSize * 3];
        idx[0] = 0;
        idx[1] = stackSize;
        idx[2] = stackSize * 2;
    }

    public void push(int stackNum, int value) {
        if(isFull(stackNum)) return;
        array[idx[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)) return -1;
        return array[--idx[stackNum]];
    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)) return -1;
        return array[idx[stackNum]-1];
    }

    public boolean isEmpty(int stackNum) {
        return idx[stackNum] - stackNum * stackSize == 0;
    }
    //尾指针和头指针重叠，就说明栈满
    private boolean isFull(int stackNum){
        return idx[stackNum] == (stackNum + 1) * stackSize;
    }
}
