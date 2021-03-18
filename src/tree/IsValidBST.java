package tree;

/**
 * @author ljj
 * @version sprint 39
 * @className IsValidBST
 * @description 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * [5,1,4,null,null,3,6]
 *
 * @date 2021-03-18 17:56:37
 */
public class IsValidBST {
    private Integer pre;
    /**
     * 题目分析：
     * 一个BST树，需要保证任意节点的左子树的所有节点小于该节点，右子树所有节点大于该节点。我们就需要遍历树，判断每个节点是否都满足这个性质。
     * 思路2：一棵BST，其中序遍历得到的是一个有序数组。我们可以根据这个特性求解，不一定非得在树上比较。
     * 解题步骤：
     * 1.定义一个全局变量pre，记录中序遍历时上个节点的值，定义一个全局变量isValid记录是否是BST。
     * 2.比较pre是否小于当前节点值，如果不小于，则不是BST，更新isValid为false
     * 3.递归是如果发现isValid是false，就直接返回
     * 4.返回isValid信息
     */
    public boolean isValidBST(TreeNode root) {
        return checkNode(root);
    }

    /**
     * 中序遍历进行检查
     */
    private boolean checkNode(TreeNode root){
       if (root==null){
           return true;
       }
       if (!checkNode(root.left)){
           return false;
       }
       if (pre==null){
           pre = root.val;
       }else{
           if (root.val <= pre){
               return false;
           }
           pre = root.val;
       }
       return checkNode(root.right);
    }
}
