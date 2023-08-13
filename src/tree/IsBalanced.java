package tree;

/**
 * @author ljj
 * @version sprint 39
 * @className IsBalanced
 * @description
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 * @date 2021-03-17 17:47:30
 */
public class IsBalanced {
    private boolean isBalance = true;
    /**
     * 题目分析：
     * 判断树是否平衡，就是判断每个节点的左右子树的高度差是否大于1、大于1不平衡，反之平衡。
     * 解题步骤：
     * 1.定义一个全局变量用于记录是否出现了高度差大于1的节点
     * 2.变量数组，获取每个节点的高度，判断是否存在插值大于1的情况
     * 3.大于1，就更新全局变量为false，然后返回全局变量即可
     * 该方法也就是对树进行后续遍历。从最下面的根节点开始判断是否平衡
     * 时间复杂度为O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root==null)return true;
        getDeep(root);
        return isBalance;
    }

    private int getDeep(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        if (Math.abs(left-right)>1){
            isBalance = false;
        }
        return (left>right?left:right)+1;
    }

    /**
     * 官方解法
     * 利用-1这个特殊的数字来标识递归中已经出现了高度大于1的情况
     * 这个解法是自最底层往上，判断每棵树是否是平衡二叉树，一旦有一个不是，就返回-1
     */
    public boolean isBalancedOther(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(isBalanced.isBalanced(root));
    }
}
