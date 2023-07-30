package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class BinaryTreePaths {
    /**
     * 我的解法，深度优先搜索，但是添加路径的实际不对
     */
    public List<String> binaryTreePathsMy(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder(root.val+"");
        if(root.left!=null){
            resultList.add(getChild(root.left,sb1));
        }
        StringBuilder sb2 = new StringBuilder(root.val+"");
        if(root.right!=null){
            resultList.add(getChild(root.right,sb2));
        }
        if(sb1.toString().equals(sb2.toString())){
            resultList.add(sb1.toString());
        }
        return resultList;
    }

    private String getChild(TreeNode root,StringBuilder result){
        if(root!=null){
            result.append("->").append(root.val);
            if(root.left!=null){
                getChild(root.left,result);
            }
            if(root.right!=null){
                getChild(root.right,result);
            }
        }
        return result.toString();
    }

    /**
     * 官方深度优先搜索，触发路径添加时机为遍历到叶子节点时，这个添加时机才是正确的时机
     * 相当于能走到叶子节点的路径才是我们需要的路径。在递归时，返回时机和保存时机很重要
     *
     * 思路与算法
     *
     * 最直观的方法是使用深度优先搜索。在深度优先搜索遍历二叉树时，我们需要考虑当前的节点以及它的孩子节点。
     *
     * 如果当前节点不是叶子节点，则在当前的路径末尾添加该节点，并继续递归遍历该节点的每一个孩子节点。
     * 如果当前节点是叶子节点，则在当前路径末尾添加该节点后我们就得到了一条从根节点到叶子节点的路径，将该路径加入到答案即可。
     * 如此，当遍历完整棵二叉树以后我们就得到了所有从根节点到叶子节点的路径。当然，深度优先搜索也可以使用非递归的方式实现，这里不再赘述。
     *
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
