package array;

/**
 * 求最长的连续的1的个数
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class LongestOnes {
    /**
     * 滑动窗口求最长的联系的1.需要注意的是，滑动窗口并不是一个固定的窗口，而是一个key移动的窗口
     * 算是双指针的升级版。因为需要用到窗口内容的和进行计算
     */
    public int longestOnes(int[] nums, int k) {
        int sum = 0;
        int begin = 0;
        int end = 0;
        while(end < nums.length){
            sum += nums[end];
            if(end - begin + 1 - sum >k){
                sum -= nums[begin];
                begin++;
            }
            end++;
        }
        return end - begin;
    }
}
