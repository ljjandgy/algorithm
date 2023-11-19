package map;

/**
 * 求省份的数量（相当于求子图的数量）
 *
 */
public class FindCircleNum {
    /**
     * 解题方法：dfs遍历图
     * 解题思路：还是遍历整个图中的所有节点，如果这个节点之前没有被遍历到，那么就从这个节点开始继续遍历。
     * 然后能重复遍历的此时，就是省份的个数，也就是不重复子图的个数
     * 其实每次递归，都会把一个子图完整的走完，只不过是深度优先的走完，而不是优先遍历同级的节点
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }
}
