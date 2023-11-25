package array;

import java.util.Arrays;
import java.util.List;

/**
 * 寻找第K大元素
 */
public class FindKthLargest {
    /**
     * 解题思路：快速排序
     * 解题方法：复习所有常见排序逻辑--优先级高
     */
    int[] nums;
        int qselect(int l, int r, int k) {
            if (l == r) return nums[k];
            int x = nums[l], i = l - 1, j = r + 1;
            while (i < j) {
                do i++; while (nums[i] < x);
                do j--; while (nums[j] > x);
                if (i < j) swap(i, j);
            }
            if (k <= j) return qselect(l, j, k);
            else return qselect(j + 1, r, k);
        }
        void swap(int i, int j) {
            int c = nums[i];
            nums[i] = nums[j];
            nums[j] = c;
        }
        public int findKthLargest(int[] _nums, int k) {
            nums = _nums;
            int n = nums.length;
            return qselect(0, n - 1, n - k);
        }
}
