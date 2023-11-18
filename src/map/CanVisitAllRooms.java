package map;

import java.util.List;

/**
 * 判断是否能进入所有的房间
 */
public class CanVisitAllRooms {
    boolean[] vis;
    int num;

    /**
     * 解题方法：深度优先搜索
     * 解题思路：每次获取到钥匙，对钥匙对应的房间进行深度优先搜索，判断没把钥匙最后能达到哪些房间，最后看是否能到达全部房间
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }
}
