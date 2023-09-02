package tree;

/**
 * 翻转树
 */
public class InvertTree {
    /**
     * 我的解题方法，具体思路为：
     * 翻转树，只需要让每棵子树的左右子树都翻转就行（从下往上的翻转）,然后返回根节点即可
     * @param root
     * @return
     */
    public TreeNode invertTreeMy(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTreeMy(root.left);
        invertTreeMy(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        return root;
    }

    /**
     * 思路和我差不多，只是利用了返回值，这样更加的直观
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
