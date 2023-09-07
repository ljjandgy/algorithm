package array;

public class LargestAltitude {
    /**
     * 利用前置和获取最高海拔
     * 思路，因为数组存的是相邻点之前的海拔差，所以可以通过遍历求和的方式，求出每个点高度值，然后维护一个最大值指针，一直指向前缀中的最高海拔，最后返回即可
     */
    public int largestAltitude(int[] gain) {
        int ans = 0, sum = 0;
        for (int x : gain) {
            sum += x;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
