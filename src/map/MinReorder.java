package map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  重新规划路线
 *  n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0
 */
public class MinReorder {
    /**
     * 解题方法：广度优先搜索
     * 解题思路：待品味
     */
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] uv : connections) {
            graph.get(uv[0]).add(new int[] {uv[1], 1});
            graph.get(uv[1]).add(new int[] {uv[0], 0});
        }

        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] v : graph.get(u)) {
                if (visited[v[0]]) {
                    continue;
                }
                visited[v[0]] = true;
                res += v[1];
                queue.offer(v[0]);
            }
        }

        return res;
    }
}
