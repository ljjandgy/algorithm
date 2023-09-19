package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断两棵树是否相似
 */
public class LeafSimilar {
    /**
     * 通过遍历树的两个节点来判断树是否相似
     */
    public boolean leafSimilarMy(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        this.addTreeNode(root1,list1);
        this.addTreeNode(root2,list2);
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();++i){
            if(list1.get(i).intValue()!=list2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void addTreeNode(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            list.add(node.val);
            return;
        }
        addTreeNode(node.left,list);
        addTreeNode(node.right,list);
    }
}
