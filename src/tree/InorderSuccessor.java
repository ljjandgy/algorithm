package tree;

/**
 * @author ljj
 * @version sprint 39
 * @className InorderSuccessor
 * @description
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 * @date 2021-03-19 14:54:35
 */
public class InorderSuccessor {
    private boolean isNeedReturn = false;
    /**
     * 题目分析：
     * 因为是获取中序遍历是的后一位。所以就是到了需要获取的节点，获取后一位就行了。关键是标记已经到了目标节点了。
     * 解题步骤：
     * 1.定义一个全局变量，记录已经到了该获取的时候了。
     * 2.中序遍历树，知道找到目标节点。并更新标志位为true
     * 3.如果标志位为true就返回当前节点，就不继续向下遍历了
     * [5,3,6,2,4,null,null,1]
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root==null){
            return null;
        }
        TreeNode node = inorderSuccessor(root.left,p);
        if (isNeedReturn){
            isNeedReturn = false;
            return root;
        }
        if (node!=null){
            return node;
        }
        if (root==p){
            isNeedReturn = true;
        }
        return inorderSuccessor(root.right,p);
    }
}
