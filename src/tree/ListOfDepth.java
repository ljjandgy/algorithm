package tree;

import linked.ListNode;

/**
 * @author ljj
 * @version sprint 39
 * @className ListOfDepth
 * @description 特定深度节点链表
 *  给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * @date 2021-03-16 11:10:48
 */
public class ListOfDepth {
    private ListNode[] result;
    private int num = -1;
    /**
     * 思路分析:
     * 因为需要把每一层的数据做为一个链表，所以遍历树时可能需要记录层数。然后把同一层的节点放到一个链表中即可
     * 解题步骤：
     * 1.获取树深度，初始化链表数组
     * 2.记录层高，没进入新的一层层高就+1，返回层高-1
     * 3.通过层高，获取链表内对象进行操作。
     * 时间复杂度O(n)
     *
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        result = new ListNode[getTreeDeep(tree)];
        preTraverse(tree);
        return result;
    }

    private void preTraverse(TreeNode node){
        ++num;
        if (node!=null){
            if (result[num]!=null){
                ListNode cur = result[num];
                while (cur.next!=null){
                    cur = cur.next;
                }
                cur.next = new ListNode(node.val);
            }else{
                result[num] = new ListNode(node.val);
            }
            preTraverse(node.left);
            --num;
            preTraverse(node.right);
            --num;
        }

    }

    private int getTreeDeep(TreeNode node){
        if (node==null){
            return 0;
        }
        //获取左子树高
        int left = getTreeDeep(node.left);
        //获取右子树高
        int right = getTreeDeep(node.right);
        return 1+(left>right?left:right);
    }
}
