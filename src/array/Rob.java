package array;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Rob {
    /**
     * 解题方法：动态规划
     * 解题思路：把偷n个房间的最大值转换为偷k-1房间最大还是偷k-2个房间+k-1的下一个房间的钱更多
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        /**
         * 没偷上个房间的最大值
         */
        int prev = 0;
        /**
         * 偷了上个房间的最大值。和prev中间差了个房间，正好满足不相邻的要求
         */
        int curr = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            //从第一个房间解释就是判断是偷第一个房间+第三个房间还是偷第二个房间
            //其实就两种偷钱逻辑，就是偷不偷最后个房间的区别
            //这个代码是核心代码，含义是如果偷了这个房间的钱，还没有偷上个房间得到的钱多，就偷上个房间，毕竟相邻的房间不能偷
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }
        return curr;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] num = {1,7,6,1,1};
        System.out.println(rob.rob(num));
    }
}
