package array;

public class MaxScore {
    /**
     * 解题方法：最小堆
     * 解题思路：待品味
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long res = 0L;
        int n = nums1.length;

        // 数组 nums2 按降序排列后的下标。
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; ++i) ids[i] = i;
        Arrays.sort(ids, (i, j) -> nums2[j] - nums2[i]);

        // nums1 的前 k - 1 个值的和
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // 小根堆
        long sum1 = 0L;
        for (int i = 0; i < k - 1; ++i) {
            int id = ids[i];
            sum1 += nums1[id];
            minHeap.offer(nums1[id]);
        }

        // 从第 k 个元素（下标 k - 1）开始计算
        for (int i = k - 1; i < n; ++i) {
            int id = ids[i];
            int num1 = nums1[id];
            // 1. 加上 num1，构成 k 个数
            sum1 += num1;
            minHeap.offer(num1);
            // 2. 比较
            res = Math.max(sum1 * nums2[id], res);
            // 3. 删除 k 个数中最小的数
            sum1 -= minHeap.poll();
        }

        return res;
    }
}
