package tree;

/**
 * @author ljj
 * @version sprint 39
 * @className PathSum
 * @description 求和路径
 *  给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * @date 2021-03-24 17:17:04
 */
public class PathSum {
    /**
     * 题目分析：
     * 题目要求我们找的是满足条件的路径，所以必然涉及树的遍历操作。而且要求路径是从根向下的情况，所以不能采用层序、中序、和后续遍历。应该采用自顶向下并按照子树遍历的前序遍历进行操作。
     * 遍历过程中，如果路径加起来的值等于目标值，那么count就+1，如果已经大于了，就换一条路径。小于就可以继续向下。到底之后需要清空路径信息。
     * 解题步骤：
     * 1.定义个全局计数器，记录可能清空
     * 2.前序遍历树，记录路径值。
     * 3.如果值等于目标值，计数器+1，如果大于就换路径，如果小于就继续向下。
     * 4.到底后清空路径
     */
    private int count;

    private int[] route;

    private int index;

    public int pathSum(TreeNode root, int sum) {
        index = 0;
        route = new int[10000];
        checkSum(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }

    public void checkSum(TreeNode node,int sum){
        if (node==null){
            return;
        }
        route[index++] = node.val;
        if (sum()==sum){
            ++count;
            return;
        }
        if (sum()<sum){
            checkSum(node.left,sum);
            route[--index<0?0:index] = 0;
            checkSum(node.right,sum);
            route[--index<0?0:index] = 0;
        }
    }

    private int sum(){
        int sum = 0;
        for (int i:route){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a= 5;
        System.out.println(--a < 0 ? 0 : a);
    }
}
