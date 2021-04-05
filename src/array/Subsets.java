package array;

import java.util.*;

/**
 * 求一个数组的全部子集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    /**
     * 第一种方法：直接拼接法。也就是不断向之前存在的数组中添加新出现的元素。实现穷举出所有子集的效果
     * 时间复杂度为O(n^2)和暴力法差不多的效率
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //先添加空数组，然后基于空数组进行其他数组的添加
        list.add(new ArrayList<>());
        for (int tmp : nums) {
            //需要在遍历过程操作自己，需要用listIterator
            ListIterator<List<Integer>> iterator = list.listIterator();
            while (iterator.hasNext()) {
                List<Integer> newList = new ArrayList<>(iterator.next());
                newList.add(tmp);
                iterator.add(newList);
            }
        }
        return list;
    }

    /**
     * 第二种方法，递归回溯法。也就是把原数组看成是一颗完全二叉树，然后对树进行深度优先遍历。每个路径都是其子集
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> res, List<Integer> path, int[]nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsets(res, path, nums, i + 1);
            //删除上一个对象，重新排布
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] ints = {1,2,3};
        subsets.subsets(ints);
    }
}
