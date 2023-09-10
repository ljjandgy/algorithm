package array;

import java.util.Arrays;

/**
 * 寻找数组的中心索引
 */
public class PivotIndex {
    /**
     * 前缀和和后缀和解题，通过比较前缀和和后缀和是否相等，来获取最左的中心索引
     */
    public int pivotIndexMy(int[] nums) {
        int sumRight = 0;
        int sumLeft = 0;
        for (int num : nums) {
            sumRight += num;
        }
        for(int i=0;i<nums.length;++i){
            sumLeft +=nums[i];
            if(sumLeft==sumRight){
                return i;
            }
            sumRight= sumRight - nums[i];
        }
        return -1;
    }

    /**
     * 前缀和的另外一种实现方式，利用在中心索引位置，2倍前缀和+当前数=总和的性质，来获取第一个中心索引
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
