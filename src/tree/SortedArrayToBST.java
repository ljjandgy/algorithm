package tree;

/**
 * 最小高度树
 *
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 */
public class SortedArrayToBST {
    private TreeNode root;
    /**
     * 题目分析：
     * 因为需要使树的高度最小，所以应该保证排序树的左子树和右子树高度一致。这样高度才是最小的。为此，我们可以找到中间节点，以中间节点为根节点，然后遍历两边的节点，挂到BST上面去。
     * 所以考虑适用双指针法解题
     * 解题步骤：
     * 1.定义两个指针，一个指向0.一个指向length-1.然后加起来除以二，为中点，也就是根节点
     * 2.遍历数组，知道两个指针重合，然后挂节点到树上去
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0) return null;
        if (nums.length==1)return new TreeNode(nums[0]);
        if (nums.length==2){
            TreeNode root =  new TreeNode(nums[0]);
            root.left = new TreeNode(nums[1]);
            return root;
        }
        int i = 0;
        int j = nums.length-1;
        root = new TreeNode(nums[j/2]);
        while (i!=j){
            putNode(root,new TreeNode(nums[i++]));
            putNode(root,new TreeNode(nums[j--]));
        }
        return root;
    }

    private void putNode(TreeNode node1,TreeNode node2){
        if (node1.val>node2.val){
            if (node1.left==null){
                node1.left = node2;
            }else{
                putNode(node1.left,node2);
            }
        }else{
            if (node1.right==null){
                node1.right = node2;
            }else{
                putNode(node1.right,node2);
            }
        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        int[] a = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST.sortedArrayToBST(a);

    }

}
