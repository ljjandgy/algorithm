package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {
    /**
     * 递归中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        getNode(root,result);
        return result;
    }

    private void getNode(TreeNode node,List<Integer> result){
        if(node==null){
            return;
        }
        getNode(node.left,result);
        result.add(node.val);
        getNode(node.right,result);
    }

    /**
     * 遍历中序遍历
     */
    public List<Integer> inorderTraversalForeach(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
