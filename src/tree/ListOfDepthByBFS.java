package tree;

import linked.ListNode;

/**
 * @author ljj
 * @version sprint 39
 * @className ListOfDepthByBFS
 * @description 通过广度优先遍历实现树的每一层转换为一个链表
 * @date 2021-03-16 17:36:25
 */
public class ListOfDepthByBFS {
    private ListNode[] result;
    private int num;
    /**
     * 广度优先遍历就是层序遍历
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        result = new ListNode[getTreeDeep(tree)];
        for(int i=0;i<result.length;++i){
            num = i;
            levelOrderTraversal(tree,i);
        }
        return result;
    }

    private void levelOrderTraversal(TreeNode root,int level){
        if (root==null){
            return;
        }
        if (level==1){
            if (result[num]==null){
                result[num] = new ListNode(root.val);
            }else{
                ListNode cur = result[num];
                while (cur.next!=null){
                    cur = cur.next;
                }
                cur.next = new ListNode(root.val);
            }
        }else if(level>1){
            //说明没有到目标层，就进入下一层
            levelOrderTraversal(root.left,--level);
            levelOrderTraversal(root.right,--level);
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
