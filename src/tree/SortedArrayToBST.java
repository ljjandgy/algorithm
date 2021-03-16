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
    /**
     * 题目分析：
     * 因为需要使树的高度最小，所以应该保证排序树的左子树和右子树高度一致。这样高度才是最小的。为此，我们可以找到中间节点，以中间节点为根节点，然后遍历两边的节点，也是取中间节点，直到两边节点数目小于1时，挂到BST上面去。
     * 所以考虑适用双指针法解题,分别是小指针和大指针，表示一个数组的开始节点和结束节点
     * 解题步骤：
     * 1.定义两个指针，一个指向0.一个指向length-1.然后加起来除以二，为中点，也就是根节点
     * 2.重复2操作，直到划分出来的单个数组只剩下小于1的节点时，就挂载子节点
     *
     * 学到了两点：
     * 1.数组判空可以同开始指针大于结束指针来实现
     * 2.最小BST依靠中值法实现，并且每次的中值就是上一个树的叶子节点，是当前树的根节点。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return putNode(nums,0,nums.length-1);
    }

    /**
     * 一直构建左右子树的根节点
     */
    private TreeNode putNode(int[] nums,int i,int j){
        // low > high表示子数组为空
        if (i > j) {
            return null;
        }
        // 以mid作为根节点
        int mid = (j + i) / 2;
        //当前树的根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 左子数组[low, mid -1]构建左子树
        root.left = putNode(nums, i, mid - 1);
        // 右子数组[mid + 1, high]构建右子树
        root.right = putNode(nums,mid + 1, j);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        int[] a = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST.sortedArrayToBST(a);
        TraverseBinaryTreeUtil.preTraverseBinaryTree(root);
    }

}
