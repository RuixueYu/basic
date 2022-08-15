package likou;

/**
 * @Author: YuRuixue
 * @Description: 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @date 2022/6/14 11:13
 */
public class LiKou121 {
    public static void main(String[] args) {
        int[] prices = {5,6,7,3,4,1};
        System.out.println(maxProfit(prices));

    }

    //dp[3][2][1] 的含义就是：今天是第三天，我现在手上持有着股票，至今最多进行 2 次交易。再比如 dp[2][3][0] 的含义：今天是第二天，我现在手上没有持有股票，至今最多进行 3 次交易。
    //本题只能最多交易一次，则第二个[]为定值1，不需要

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        //第一个[] 表示第几天，第二个[] 表示持有还是卖出，1持有，0还未买入或卖出
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) {
            //初始状态 第0天
            if(i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            //状态转移方程
            //第i天未持有股票有两种情况，1.第i-1天未持有 2.第i—1天持有，第i天卖出，收入加prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i -1][1] + prices[i]);

            //第i天持有股票有两种情况，1.第i-1天就持有 2.第i—1天未持有，第i天买入，消费prices[i]
            dp[i][1] = Math.max(dp[i -1][1], -prices[i]);
        }
        //前一天卖出，利润最大
        return dp[n - 1][0];
    }
}
