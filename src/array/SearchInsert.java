package array;

/**
 * 在数组中寻找目标值的位置，题目如下
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */
public class SearchInsert {
    /**
     * 我的解法
     * @param nums 数组
     * @param target 目标值
     * @return
     */
    int my(int[] nums, int target){
        if(nums==null){
            return 0;
        }
        int insertIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0&&target<nums[i])
                return 0;
            if(target==nums[i]){
                return i;
            }
            if(target<nums[i]&&insertIndex==0){
                insertIndex = i;
            }
        }
        return insertIndex==0?nums.length:insertIndex;
    }

    /**
     * 大佬的解法
     * @return
     */
    int dalao(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) continue;
            return i;
        }
        return nums.length;
    }
}
