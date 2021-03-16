package tree;

/**
 * @author ljj
 * @version sprint 12
 * @className TraverseBinaryTreeUtil
 * @description
 * @date 2020-11-24 17:50:05
 */
public class TraverseBinaryTreeUtil {
    private TraverseBinaryTreeUtil(){}

    /**
     * 先序遍历 根->左子树->右子树
     * @param node 树节点对象
     */
    public static void preTraverseBinaryTree(TreeNode node){
        if (node!=null){
            System.out.print(node.val+"->");
            //左节点
            preTraverseBinaryTree(node.left);
            //右节点
            preTraverseBinaryTree(node.right);
        }
    }

    /**
     * 中序遍历 左子树->根->右子树
     * @param node 树节点
     */
    public static void inTraverseBinaryTree(TreeNode node){
        if (node!=null){
            //先遍历左子树，找到最左子树的左叶子节点
            inTraverseBinaryTree(node.left);
            //输出节点值
            System.out.print(node.val+"->");
            //遍历当前子树根节点的右子树
            inTraverseBinaryTree(node.right);
        }
    }

    /**
     * 后序遍历 左子树->右子树->根
     * @param node 树节点
     */
    public static void postTraverseBinaryTree(TreeNode node){
        if (node!=null){
            //先遍历左子树，找到最左子树的左叶子节点
            postTraverseBinaryTree(node.left);
            //遍历当前子树根节点的右子树
            postTraverseBinaryTree(node.right);
            //输出节点值
            System.out.print(node.val+"->");
        }
    }

    /**
     * 前序遍历查找节点
     * @param node 节点
     * @param target 目标值
     */
    static TreeNode preTraverseSearch(TreeNode node,int target){
        if (node!=null){
            if (target == node.val){
                return node;
            }
            TreeNode resultNode;
            resultNode = preTraverseSearch(node.left,target);
            if (resultNode==null){
                resultNode = preTraverseSearch(node.right,target);
            }
            return resultNode;
        }
        return null;
    }

    /**
     * 中序遍历查找二叉树
     * @param node 二叉树节点
     * @param target 目标
     * @return 满足要求的二叉树节点
     */
    static TreeNode inTraverseSearch(TreeNode node,int target){
        if (node!=null){
            TreeNode resultNode;
            resultNode = inTraverseSearch(node.left,target);
            if (node.val == target){
                return node;
            }
            if (resultNode == null){
                resultNode = inTraverseSearch(node.right,target);
            }
            return resultNode;
        }
        return null;
    }

    /**
     * 后序遍历查找二叉树
     * @param node 二叉树节点
     * @param target 目标
     * @return 符合要求的节点
     */
    static TreeNode postTraverseSearch(TreeNode node,int target){
        if (node!=null){
            TreeNode resultNode;
            resultNode = postTraverseSearch(node.left,target);
            if (resultNode==null){
                resultNode = postTraverseSearch(node.right,target);
            }
            if (node.val == target){
                return node;
            }
            return resultNode;
        }
        return null;
    }
}
