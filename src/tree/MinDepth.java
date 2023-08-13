package tree;

public class MinDepth {
    private int minDepth = -1;
    public int minDepth(TreeNode root) {
        this.getDepth(root,1);
        return minDepth==-1?0:minDepth;
    }
    /**
     * 每次向下都+1的深度，回到根节点-1，到叶子节点进行深度比较，小于最小，则替换
     * 实际操作时，不需要考虑深度-1，因为递归回归时，深度会使用++前的方法帧里面的数值，自动-1
     * 关键是触发时机，也就是到根节点才更新树的深度
     */
    private void getDepth(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(minDepth==-1||depth<minDepth){
                minDepth = depth;
            }
        }else{
            depth++;
            getDepth(root.left,depth);
            getDepth(root.right,depth);
        }
    }

    /**
     *
     * 题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点
     *
     * 题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果
     *
     * 另外这道题的关键是搞清楚递归结束条件
     *
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     * 针对每个节点都球最小值即可
     */
    public int minDepthOther(TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }
}
