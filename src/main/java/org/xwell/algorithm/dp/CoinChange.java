package org.xwell.algorithm.dp;

import java.util.Arrays;

/**
 * no.322 零钱兑换
 * @author xwell
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n < 1 || amount < 1) {
            return -1;
        }
        int max = amount + 1;
        // 状态定义，dp[i] 表示凑齐金额 i 所需的最小硬币个数
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i < max; i++) {
            // 找出所有可能状态转移过来的最小值          
            for(int coin : coins){
                // 若金额 i 小于当前硬币面值，dp[i] 不可能从其状态转移过来，忽略
                if(i>=coin){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        //如果没有更新 dp[amount]，说明没找到可用组合，返回 -1 即可
        return dp[amount]==max?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange test = new CoinChange();
        int res = test.coinChange(coins, amount);
        System.out.println(res);
    }
}
