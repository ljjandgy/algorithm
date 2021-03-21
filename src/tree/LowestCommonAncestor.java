package tree;

public class LowestCommonAncestor {
    /**
     * 解题思路：
     * 要求找最近的共同祖先，其实就是找同时包含两个节点的最小的树的根节点。为此，我们可以采用DFS的方式进行遍* 历，查找目标节点。
     * 解题步骤：
     * 1.定义一个节点记录后出现的pq节点。后续遍历树，如果找到节点就返回相遇节点。
     * 2.如果左子树遍历和右子树遍历分别返回了pq，则当前节点为根节点的树包含了pq，返回当前节点即可。
     * 3.如果一直都没有出现左右子树的情况，就返回最后出现的节点。
     **/
    private TreeNode ans;

    public LowestCommonAncestor() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}
