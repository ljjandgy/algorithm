package map;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 寻找最近的出口
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 *
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 *
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 */
public class NearestExit {
    /**
     * 解题方法：bfs
     * 解题思路：待细品
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{0, 1, 0, -1}, {1, 0, -1, 0}};

        //记录已经访问过的点的坐标
        Queue<int[]> queue = new LinkedList<>();
        //将入口加入队列
        queue.offer(new int[] {entrance[0], entrance[1], 0});//最后一位表示当前走了几步
        // 遍历到的坐标变为墙 防止重复遍历
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int[] curLocal = queue.poll(); // 坐标出队
            int row = curLocal[0]; //坐标行
            int col = curLocal[1]; //坐标列
            for(int i = 0; i < 4; i++){
                int x = row + directions[0][i];
                int y = col + directions[1][i];
                // 新坐标合法 且 不为墙
                if(x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1 && maze[x][y] == '.'){
                    // 新坐标为出口
                    if(x == 0 || x == m - 1 || y == 0 || y == n - 1){
                        return curLocal[2] + 1; // 多迈一步才能走出迷宫
                    }
                    queue.offer(new int[] {x, y, curLocal[2] + 1});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }
}
