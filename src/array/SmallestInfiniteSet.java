package array;

import java.util.TreeSet;

/**
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 *
 * 实现 SmallestInfiniteSet 类：
 *
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 */
public class SmallestInfiniteSet {
    private int thres;
    private TreeSet<Integer> set;

    /**
     * 解题方法：有序集合
     * 解题思路：
     * 使用一个整数 thres表示现在能入队列的最小值+1.利用treeSet存储重新入栈元素信息
     * thres和treeSet的交集就是实际损失的元素
     */
    public SmallestInfiniteSet() {
        thres = 1;
        set = new TreeSet<>();
    }

    /**
     * 如果treeSet为空，就取其中第一个元素，因为是按照元素默认顺序进行的存储
     */
    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = thres;
            ++thres;
            return ans;
        }
        int ans = set.pollFirst();
        return ans;
    }

    /**
     * 如果插入的值没有小于能入队列的最小值，就不进行存储，反之，进入TreeSet
     */
    public void addBack(int num) {
        if (num < thres) {
            set.add(num);
        }
    }
}
