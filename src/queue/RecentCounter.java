package queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 通过队列获取某个区间内的请求次数
 */
public class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            //如果请求时间比下限值还小，就可以直接删除了，针对统计来说已经是无效请求了
            queue.poll();
        }
        return queue.size();
    }
}
