package tree;

public class DeleteNode {
    /**
     * 删除二叉搜索树中的某个节点
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 解题方法：递归（前序遍历）
         * 其实就是保证删除了节点之后，新节点能继续保证二叉搜索树的性质：
         * 根>左>右（值）
         */
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            //把删除之后得到的新节点作为新的子节点
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            //把删除之后得到的新节点作为新的子节点
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            //右子树最小节点作为新的root节点
            while (successor.left != null) {
                successor = successor.left;
            }
            //删除自己
            root.right = deleteNode(root.right, successor.val);
            //把最小节点作为新的子树根节点，继承其左右子树信息
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
