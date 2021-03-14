package stack;

import java.util.LinkedList;

/**
 * 解题思路：直接用一个链表存储对象，每次插入都在链表尾部，这样头部的动物就比尾部来的早。
 * 值得学习的是一个动物应该用数组表示，而不是单个数字。其次是对于公用内容可以提前定义好。然后复用，可以减少对象反复创建的诗句
 */
public class AnimalShelfFastest {
    LinkedList<int[]> list;
    int[] error = new int[]{-1,-1};
    public AnimalShelfFastest() {
        list = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        list.offer(animal);
    }

    public int[] dequeueAny() {
        if(!list.isEmpty())
            return list.pollFirst();
        else
            return error;
    }

    public int[] dequeueDog() {
        for(int i=0;i<list.size();i++){
            if(list.get(i)[1]==1){
                int[] ans = list.get(i);
                list.remove(i);
                return ans;
            }
        }
        return error;
    }

    public int[] dequeueCat() {
        for(int i=0;i<list.size();i++){
            if(list.get(i)[1]==0){
                int[] ans = list.get(i);
                list.remove(i);
                return ans;
            }
        }
        return error;

    }
}
