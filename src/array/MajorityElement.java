package array;

import java.util.Arrays;

/**
 * 多数元素
 */
public class MajorityElement {
    /**
     * 排序获得众数
     */
    public int majorityElement(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //因为目标值大于n/2也就是众数，所以排序完之后，1/2处的数肯定是众数
        return nums[nums.length / 2];
    }
}
