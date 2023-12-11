package array;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class FindPeakElement {
    /**
     * 解题方法：二分法
     * 解题思路：首先通过二分法找到数组中间，然后判断其是否比后面的数大，如果大于，则他有可能是峰值，所以往左继续二分。反之往右二分
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
