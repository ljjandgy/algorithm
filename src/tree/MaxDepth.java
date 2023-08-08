package tree;

public class MaxDepth {
    /**
     * 深度优先遍历获取树最大深度
     * 思路：根据树的特性，树的最大深度等于左子树和右子树中最大值+1
     * 然后只需要求出左子树和右子树的高度，取最大值+1即可
     * 上面逻辑针对每个节点都适用，然后层层计算，最终获得根节点的高度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
