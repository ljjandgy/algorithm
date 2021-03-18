package tree;

/**
 * 解题思路：
 * 利用取值区间来判断一棵树是否是BST，如果是BST，那么它应该满足左子树都比自己小，右子树都比自己大。所以，在遍历某个节点的左子树时，自己是这棵树的最大值，遍历右子树时，自己是这棵树的最小值。
 * 同理，遍历自己左子树的右子树时，自己就是最大值，左儿子就是最小值。这样就形成了一个个树的取值区间，如果树里面出现了不满足的节点，就说明树不是BST。
 * 其实关键的是就是某个节点的左子树的右子树，因为右子树会比根节点大，所以我们需要保证其比根节点的父节点要小才行，因为他们作为左子树不能大过根节点。
 */
public class IsValidBSTInterval {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    private boolean isValidBST(TreeNode root ,TreeNode min,TreeNode max){
        if(root == null) return true;
        if(min != null && root.val <= min.val)return false;
        if(max != null && root.val >= max.val)return false;
        return isValidBST(root.left,min,root)&& isValidBST(root.right,root,max);
    }
}
