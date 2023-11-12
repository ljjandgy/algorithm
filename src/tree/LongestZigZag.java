package tree;

/**
 * 求树的最长交叉路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 */
public class LongestZigZag {
    int maxAns;

    /**
     * 解题方法：深度优先遍历
     * 解题思路：每次向下遍历，都向下传递深度以及本次遍历，是向右走会增加深度，还是向左走会增加深度，不增加深度时，深度清0，因为同方向了。
     * 然后每次遍历都比较当前交叉深度和之前最大交叉深度谁最大，然后取最大值维护到最大深度maxAns中去
     */
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxAns;
    }

    public void dfs(TreeNode o, boolean dir, int len) {
        maxAns = Math.max(maxAns, len);
        if (!dir) {
            if (o.left != null) {
                dfs(o.left, true, len + 1);
            }
            if (o.right != null) {
                dfs(o.right, false, 1);
            }
        } else {
            if (o.right != null) {
                dfs(o.right, false, len + 1);
            }
            if (o.left != null) {
                dfs(o.left, true, 1);
            }
        }
    }
}
