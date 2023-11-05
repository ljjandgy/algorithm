package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class PredictPartyVictory {
    /**
     * 解题方法：循环队列
     * 循环队列就是队列中最后一个存储空间指向了队首的队列，这样遍历队列时可以全部遍历
     * 在算法中这个方法的核心就是不仅要从队列中取出数据，还要往队列中插入数据，通常是把计算结果插回，然后后面再使用
     * @param s
     * @return
     */
    public String predictPartyVictory(String s) {
        Deque<Integer> rd = new ArrayDeque<>(), dd = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') rd.addLast(i);
            else dd.addLast(i);
        }
        while (rd.size() != 0 && dd.size() != 0) {
            int a = rd.pollFirst(), b = dd.pollFirst();
            if (a < b) rd.addLast(a + n);
            else dd.addLast(b + n);
        }
        return rd.size() != 0 ? "Radiant" : "Dire";
    }
}
