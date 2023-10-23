package array;

/**
 * 删除数组中的重复元素2
 */
public class RemoveDuplicatesTwo {
    /**
     * 以数组 nums = [1,1,1,2,2,3] 和 k = 2 为例来解释这段代码。
     *
     * 初始化 slow = k = 2 和 fast = k = 2。此时，数组为 [1,1,1,2,2,3]，slow 和 fast 都指向第三个元素 1。
     * 进入 while 循环，检查 nums[fast]（即 1）是否不等于 nums[slow - k]（即 1）。因为它们相等，所以不进行复制，直接将 fast 向前移动一位。此时，数组为 [1,1,1,2,2,3]，slow 指向第三个元素 1，fast 指向第四个元素 2。
     * 再次进入 while 循环，检查 nums[fast]（即 2）是否不等于 nums[slow - k]（即 1）。因为它们不等，所以将 nums[fast] 复制到 nums[slow]，并将 slow 向前移动一位。然后，将 fast 向前移动一位。此时，数组为 [1,1,2,2,2,3]，slow 指向第四个元素 2，fast 指向第五个元素 2。
     * 重复这个过程，直到 fast 指向数组的末尾。最后，数组为 [1,1,2,2,3,3]，slow 指向第五个元素 3。
     * 返回 slow，即新数组的长度。在这个例子中，新数组的长度为 5，新数组为 [1,1,2,2,3]。
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        //slow指针其实是用于计数的
        return slow;
    }
}
