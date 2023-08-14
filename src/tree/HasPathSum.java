package tree;

/**
 * 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class HasPathSum {
    /**
     * 利用DFS进行路径计算，每往下一个节点，就减去当前节点的值，如果到叶子节点能变成0，则说明这个路径满足，否则为不满足
     * 值得注意的是，这次左右子树的是逻辑或的关系
     */
    public boolean hasPathSumMy(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        targetSum = targetSum - root.val;
        if(root.left==null&&root.right==null){
            return targetSum==0;
        }
        return hasPathSumMy(root.left,targetSum) || hasPathSumMy(root.right,targetSum);
    }

    /**
     * 官方版本，思路一致，代码更加优雅，把减的动作放到了入参里面，减少了方法体的逻辑
     * 并且最后判断是判断值相等，而不是等于0
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
