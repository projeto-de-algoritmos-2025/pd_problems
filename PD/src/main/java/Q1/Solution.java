package Q1;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) 
            for (int coin : coins) 
                if (i >= coin) 
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                
        return dp[amount] > amount ? -1 : dp[amount];
    }
}