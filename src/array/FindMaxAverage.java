package array;

/**
 * 求子数组最大平均数
 */
public class FindMaxAverage {
    /**
     * 滑动窗口获取长度k的子数组的最大平均值
     *
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            //利用前一个窗口的和快速算出下一个窗口的和，不用遍历k次
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
