package array;

/**
 * 进入股票的最佳时机 第一版
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    /**
     * 我的low比方法，290ms
     * @return
     */
    int my(int[] prices){
        if(prices==null){
            return 0;
        }
        int max = 0;
        int length = prices.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    /**
     * 大佬的写法 1ms
     * 大佬写法的奥秘：先分析问题的本质，再作答。
     * 针对题目，我们需要关心的是价格折线图的最小值及最小值后的最大值即可。并且把这个值和之前的峰谷差做比较即可
     * 用minprice记录买入的价格，也就是当前出现过的价格中的最小值
     * 用maxprice记录最大差价，获取到最大差价的价格就是卖出价格
     *
     * 得到的启发，先分析，再动手写，不用总是想着最基础的方法来实现。
     * @param prices
     * @return
     */
    int dalao(int[] prices){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
