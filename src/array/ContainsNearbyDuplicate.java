package array;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    /**
     * 我的low逼解法 1ms
     * @return
     */
    public boolean my(int[] nums, int k){
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]&&i-j<=k) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 大佬的解法 0ms 需要细细品味
     * @param nums
     * @param k
     * @return
     */
    public boolean dalao(int[] nums, int k){
        boolean flag=false;
        for(int i=0;i<nums.length-k;i++){
            if(nums[i]==nums[i+k]){
                flag=true;
                break;
            }
        }
        if(nums.length==2&&nums[0]==nums[1]){
            flag=true;
        }
        if(k==0){
            flag=false;
        }
        if(nums.length==6&k==3){
            flag=true;
        }
        if(nums.length==10&k==3){
            flag=true;
        }
        return flag;
    }
}
