package array;

import java.util.Arrays;

/**
 * 求最大操作次数
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 */
public class MaxOperations {
    /**
     * 排序后在进行操作，这样更方便进行比较，大了右指针左移，小了左指针右移，直到相等
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int num = 0;
        while(r>l){
            if(nums[l]+nums[r]>k){
                r--;
            }else if(nums[l]+nums[r]==k){
                l++;
                r--;
                num++;
            }else{
                l++;
            }
        }
        return num;
    }
}
