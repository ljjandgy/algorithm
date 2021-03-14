package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 动物收容所
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * 示例1:
 *
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 *
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 *  输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 *
 */
public class AnimalShelf {
    /**
     * 题目分析：由于是先进先出，所以考虑适用队列实现。并且由于有猫狗两个类型。所以可能需要两个队列进行存储。一个存猫，一个存狗。
     * 然后队列需要提供三个方法，其中一个是取猫最老的，一个取狗最老的，一个取所有动物中最老的。所以我们除了两个队列外，还需要考虑记录当前最老的编号是多少。
     * 所以最终可能需要三个队列，一个存猫，一个存狗，一个存所有动物，分别对应三个方法的取值。
     */
    private Deque<Integer> cat = new LinkedList<>();
    private Deque<Integer> dog = new LinkedList<>();
    private int[] error = new int[]{-1,-1};
    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        if (animal[1]==0){
            cat.addLast(animal[0]);
        }else{
            dog.addLast(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (cat.isEmpty()&&dog.isEmpty()){
            return error;
        }
        if (cat.isEmpty()){
            return new int[]{dog.pop(),1};
        }else if(dog.isEmpty()){
            return new int[]{cat.pop(),0};
        }
        boolean isDogOldest = cat.peek()>dog.peek();
        return new int[]{isDogOldest?dog.pop():cat.pop(),isDogOldest?1:0};
    }

    public int[] dequeueDog() {
        if (dog.isEmpty()){
            return error;
        }
        return new int[]{dog.pop(),1};
    }

    public int[] dequeueCat() {
        if (cat.isEmpty()){
            return error;
        }
        return new int[]{cat.pop(),0};
    }
}
