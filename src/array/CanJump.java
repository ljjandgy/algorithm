package array;

public class CanJump {
    /**
     * 解题方法：贪心算法
     * 解题思路：每次跳跃都判断能不能能不能达到终点即可。
     * 就是每次跳跃都计算下加上现在的格子加上最大跳跃距离能不能达到终点，如果可以，则返回true，如果遍历完都不行，就返回false
     * 其实这道题就是问从某个格子出发，能不能达到终点
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
