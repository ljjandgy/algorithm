package array;

/**
 * 买卖股票的最佳时机 二
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfitTwo {
    /**
     * 我的low逼方法
     * @return
     */
    int my(){
        //没有写出来
        return 0;
    }

    /**
     * 大佬写法，一次遍历得到结果 2ms
     * 时间复杂度：O(n)。遍历一次。
     * 空间复杂度：O(1)。需要常量的空间。
     *
     * 解法奥秘：
     * 直接计算可能出现的利润，利润和就是反复买卖能获得的最大营利，毕竟波峰和波谷的插值等于中间相邻节点插值之和
     * 只是单纯用贪心计算最大利润，而不是实际的一个交易过程
     * @param prices
     * @return
     */
    int dalao(int[] prices){
        if(prices==null){
            return 0;
        }
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            //后面节点如果比前面节点打，说明赚钱，就在利润上加上差值
            if (prices[i] > prices[i - 1])
                //增加利润
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    /**
     * 动态规划解法：
     * 本质就是利用前一天持股与不持股的利润和今天持股与不持股的利润进行比较，判断啥时候卖，啥时候买，寻找所有完整的波峰波谷，从而实现利润最大化。针对这到题，还是贪心好理解
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        //不持有股票的利润
        int cash = 0;
        //持有股票的利润，一开始如果选择了持有股票，那么利润肯定是负数
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            //可以找到一个波峰波谷周期买入与卖出
            //preHold + prices[i] 表示昨天持有股票，并且今天卖出股票的话能有多少总利润，通过这个数值的不断叠加，就能获取最大利润
            //今天卖的利润
            cash = Math.max(preCash, preHold + prices[i]);
            //今天不卖的利润 preCash - prices[i] 表示今天如果买入股票的话利润是多少，针对价格上升的场景，这个值肯定比preHold前一天买入股票的利润要低，因为股票价格上升了，
            // 针对价格下降的场景，则会比preHold要高，这表明前一天卖的话能赚钱，就会导致hold值变大，相当于积累了一次利润了
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;

    }
}
