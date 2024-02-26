package array;

public class RemoveDuplicates {
    /**
     * 双指针删除数组重复元素，其中判断循环条件时只需要判断fast指针即可
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        //slow指针其实是用于计数的
        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] arr = {1,1,2};
        removeDuplicates.removeDuplicates(arr);
    }
}
