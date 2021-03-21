package tree;

public class LowestCommonAncestorCorrect {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 1、说明 root 的左 / 右子树中都不包含 p,q ，返回 null
        if (left == null && right == null) {
            return null;
        }
        // 3、当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
        // ①、p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
        // ②、p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点
        if (left == null) {
            return right;
        }
        // 4、当 left 不为空 ， right 为空 ：与情况 3. 同理
        if (right == null) {
            return left;
        }
        // 2、说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root
        return root;
    }

}
