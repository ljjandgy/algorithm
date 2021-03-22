package tree;

/**
 * @author ljj
 * @version sprint 39
 * @className CheckSubTree
 * @description 检查子树
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 *
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 *
 * 注意：此题相对书上原题略有改动。
 *
 * 示例1:
 *
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 * 示例2:
 *
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 *
 * @date 2021-03-23 17:55:33
 */
public class CheckSubTree {
    /**
     * 题目分析：
     * 其实就是判断一棵树的某棵子树的按照某个顺序遍历，每个节点的值是否和另外棵树一样。所有我们需要对T1进行遍历，判断有没有节点对应的树和T2每个节点都一样（值和位置）
     * 解题步骤：
     * 1.层序遍历T1，判断查找个t2根节点值一致的节点，然后从对这个节点所在子树进行层序遍历，判断两棵树节点是否一致。
     * 2.如果没找到根节点一样的节点，就返回false。
     * 3.如果遍历出现不一致，就继续向下遍历查找。然后重复1,2步操作
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        TreeNode t1Tmp = t1;
        while (t1Tmp!=null&&t1Tmp.val!=t2.val){
            t1
        }
    }
}
