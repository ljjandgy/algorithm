package array;

/**
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Merge {
    /**
     * 我的解法 6ms
     * @param nums1
     */
    void my(int[] nums1, int m, int[] nums2, int n){
        for(int i=m;i<m+n;i++){
            nums1[i] = nums2[m+n-i-1];
        }
        int max = nums1[0];
        int maxIndex = 0;
        for(int i=m+n-1;i>0;i--){
            for(int j=1;j<=i;j++){
                if(nums1[j]>max){
                    max = nums1[j];
                    maxIndex = j;
                }

            }
            nums1[maxIndex] = nums1[i];
            nums1[i] = max;
            maxIndex = 0;
            max = nums1[0];
        }
    }

    /**
     * 大佬的解法，3ms
     */
    void dalao(int[] nums1, int m, int[] nums2, int n){
        int i=m-1,j=n-1,p = m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]<nums2[j])
                nums1[p--]=nums2[j--];
            else
                nums1[p--]=nums1[i--];
        }
        if(i<0)
            while(j>=0)
                nums1[p--]= nums2[j--];
    }
    /**
     * 需要注意内容：
     * 双指针排序，需要注意的是，需要从后往前遍历，这样能不用移动数字中元素位置（比起从前向后循环）
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            //取出最大的数，然后从后往前放，这样不用移动数组内的数值
            //当双指针中其中一个指针为负数时，就表示其中一个数组已经遍历完了，另外个数据的身下部分直接填充nums1即可
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
