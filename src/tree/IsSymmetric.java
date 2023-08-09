package tree;

/**
 * 判断一棵树是否轴对称
 */
public class IsSymmetric {
    /**
     * 递归判断一棵树是否轴对称
     * 如果同时满足下面的条件，两个树互为镜像：
     *
     * 它们的两个根结点具有相同的值
     * 每个树的右子树都与另一个树的左子树镜像对称
     * 关键在于同时传入两个节点进行比较，递归时需要考虑每次递归需要进行的逻辑，不要固话只传递一个对象
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
