package array;

/**
 * 连续子序列最大和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    /**
     * 我的解法--16ms
     * @return
     */
    int my(int[] nums){
        if(nums==null){
            return 0;
        }
        int sum = 0;//当前连续数组的总和
        int res = 0;//返回结果
        boolean flag = true;//是否全是负数
        int max = nums[0];//数组中的最大值
        for(int num:nums){
            if(num>=0){
                flag = false;
            }
            if(sum>0){
                sum = num+sum;
            }else{
                sum = num;//如果sum小于等于0，直接重新开始求和
            }
            res = Math.max(res,sum);
            max = Math.max(max,num);
        }
        if(flag){
            return max;
        }
        return res;
    }

    /**
     * 大佬的解法 7ms
     * @return
     */
    int dalao(int[] nums){
        int maxSum = nums[0];
        int curSum = 0;

        for (int n: nums) {
            curSum += n;
            if (curSum > maxSum) { maxSum = curSum; }
            if (curSum < 0) { curSum = 0; }
        }

        return maxSum;
    }
}
