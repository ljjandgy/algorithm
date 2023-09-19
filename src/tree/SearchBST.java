package tree;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */
public class SearchBST {
    /**
     * 暴力寻找，没有考虑BST的性质
     */
    public TreeNode searchBSTMy(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val ==val){
            return root;
        }
        TreeNode left = searchBSTMy(root.left,val);
        if(left!=null){
            return left;
        }
        return searchBSTMy(root.right,val);

    }

    /**
     * 利用了二叉搜索树的性质，减少了递归的次数
     * 二叉搜索树满足如下性质：
     *
     * 左子树所有节点的元素值均小于根的元素值；
     * 右子树所有节点的元素值均大于根的元素值。
     * 据此可以得到如下算法：
     *
     * 若 root\textit{root}root 为空则返回空节点；
     * 若 val=root.val\textit{val}=\textit{root}.\textit{val}val=root.val，则返回 root\textit{root}root；
     * 若 val<root.val\textit{val}<\textit{root}.\textit{val}val<root.val，递归左子树；
     * 若 val>root.val\textit{val}>\textit{root}.\textit{val}val>root.val，递归右子树。
     *
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }
}
