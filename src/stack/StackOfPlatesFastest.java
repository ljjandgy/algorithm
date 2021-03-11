package stack;

/**
 * 堆盘子最快版本，采用链表+数组实现。其中数组存储的是单个栈的内容，链表表示不同的栈
 */
public class StackOfPlatesFastest {
    int length;
    //链表头节点，永远指向第一个栈的栈底
    node head;
    //链表尾节点，指向最后一个栈的栈底，链表只记录了栈底对象的信息，对象里面的arr记录了这个栈内容信息
    node curNode;
    public StackOfPlatesFastest(int cap) {
        length = cap;
        head = new node(cap);
        curNode = head;
    }

    public void push(int val) {
        if (length == 0) {
            return;
        }
        if (curNode == head || curNode.index == length) {
            node newNode = new node(length);
            curNode.next = newNode;
            newNode.pre = curNode;
            curNode = newNode;
        }
        curNode.arr[curNode.index++] = val;
    }

    public int pop() {
        if (curNode == head || length == 0) {
            return -1;
        }
        int res = curNode.arr[curNode.index - 1];
        if (--curNode.index == 0) {
            deleteNode(curNode);
        }
        return res;
    }

    public int popAt(int index) {
        node curNode = head.next;
        while (index > 0 && curNode != null) {
            curNode = curNode.next;
            index--;
        }
        if (curNode == null || length == 0) {
            return -1;
        }
        int res = curNode.arr[curNode.index - 1];
        if (--curNode.index == 0) {
            deleteNode(curNode);
        }
        return res;
    }

    public void deleteNode(node dNode) {
        node pre = dNode.pre;
        node next = dNode.next;
        pre.next = next;
        if (next != null) {
            next.pre = pre;
            curNode = next;
        } else {
            curNode = pre;
        }
    }

    class node {
        //逆序存储节点，第0个是栈底
        int[] arr;
        int index;
        node next;
        node pre;
        node (int k) {
            arr = new int[k];
            index = 0;
        }
    }
}
