package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 */
public class MaxLevelSum {
    /**
     * 解题方法：广度优先搜索
     * 解题思路：其实就是不断遍历树，用一个数组来存储当前层级的节点，用一个数组存储下一个层级的节点，第一个数组指向第二个数组时，层级+1
     * 维护一个最大值及其层级，只有当后面的和大于最大值时，才更新，保证了记录的层级是最小的
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        int ans = 1, maxSum = root.val;
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        for (int level = 1; !q.isEmpty(); ++level) {
            List<TreeNode> nq = new ArrayList<TreeNode>();
            int sum = 0;
            for (TreeNode node : q) {
                sum += node.val;
                if (node.left != null) {
                    nq.add(node.left);
                }
                if (node.right != null) {
                    nq.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            q = nq;
        }
        return ans;
    }
}
