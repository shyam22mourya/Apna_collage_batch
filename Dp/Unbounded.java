package Dp;

import java.util.*;

public class Unbounded {
    // Using recursion
    public static int unKnapsack(int val[], int wt[], int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        // valid
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + unKnapsack(val, wt, w - wt[n - 1], n);
            // exclude
            int ans2 = unKnapsack(val, wt, w, n - 1);
            return Math.max(ans1, ans2);
        } else { // not valid
            return unKnapsack(val, wt, w, n - 1);
        }
    }

    // using tabu
    public static int unKnapsackTabu(int val[], int wt[], int sum) {
        int N = val.length;
        int W = sum;
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int W = amount;
        int dp[][] = new int[N + 1][W + 1];

        // Initialize DP table
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j == 0)
                    dp[i][j] = 0; // 0 coins needed for amount 0
                else
                    dp[i][j] = Integer.MAX_VALUE - 1; // Large value (infinity)
            }
        }

        // Fill DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (coins[i - 1] <= j) { // Coin can be included
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                } else { // Coin cannot be included
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[N][W] == Integer.MAX_VALUE - 1 ? -1 : dp[N][W]; // If still infinite, return -1
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int amount = 8;
        // CoinChange cc = new CoinChange()
        RodCut rd = new RodCut();
        System.out.println(rd.rodCuttingM(length, price, amount));
    }
}

class CoinChange {

    //using recurtion
    public int coinChangeR(int[] coins, int amount, int index) {
        // Base Cases
        if (amount == 0)
            return 1; // Found one valid way
        if (index >= coins.length || amount < 0)
            return 0; // Invalid case

        // Recursive Case:
        // 1. Include the current coin (stay at the same index)
        int include = coinChangeR(coins, amount - coins[index], index);

        // 2. Exclude the current coin (move to the next index)
        int exclude = coinChangeR(coins, amount, index + 1);

        return include + exclude;
    }

    public int coinChangeMe(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        // Fill with -1 to indicate "not yet computed"
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = helper(coins, amount, coins.length, dp);
        return (result != 0) ? result : -1;
    }

    private int helper(int[] coins, int amount, int n, int[][] dp) {
        // Base case: If amount is 0, there's 1 way to make the sum (by choosing
        // nothing)
        if (amount == 0)
            return 1;
        // If no coins left and amount is still positive, no way to make the sum
        if (n == 0)
            return 0;

        // If already computed, return stored value
        if (dp[n][amount] != -1)
            return dp[n][amount];

        // If the current coin is less than or equal to the amount, we have two choices:
        if (coins[n - 1] <= amount) {
            // 1. Include the coin: Reduce the amount and stay at the same index
            // 2. Exclude the coin: Move to the next index
            dp[n][amount] = helper(coins, amount - coins[n - 1], n, dp) + helper(coins, amount, n - 1, dp);
        } else {
            // Exclude the coin (can't use it)
            dp[n][amount] = helper(coins, amount, n - 1, dp);
        }

        return dp[n][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int W = amount;
        int dp[][] = new int[N + 1][W + 1];

        for (int i = 0; i < N + 1; i++) {
            // i == coins , j == amount
            // if my amount is 0 so 1 ways to give answer
            dp[i][0] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (coins[i - 1] <= j) { // valid conditions
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else { // invalid  
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        print(dp);
        return dp[N][W] != 0 ? dp[N][W] : -1;
    }

    public void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

}

class RodCut {

    public int rodCuttingM(int length[], int price[], int rodLen) {
        int n = length.length;
        int dp[][] = new int[n][rodLen + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rodLen + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(length, price, dp, rodLen, n - 1);
    }

    private int helper(int length[], int price[], int dp[][], int lgth, int index) {
        if (index < 0 || lgth == 0) {
            return 0;
        }
        if (dp[index][lgth] != -1) {
            return dp[index][lgth];
        }

        // If current rod length is less than or equal to lgth, we have 2 choices
        if (length[index] <= lgth) {
            int include = price[index] + helper(length, price, dp, lgth - length[index], index);
            int exclude = helper(length, price, dp, lgth, index - 1);
            dp[index][lgth] = Math.max(include, exclude);
        } else {
            // Otherwise, we can only exclude the current piece
            dp[index][lgth] = helper(length, price, dp, lgth, index - 1);
        }
        return dp[index][lgth];
    }

    // tabulation
    public int rodCuttingT(int length[], int price[], int rodLen) {
        // step1 creat table 
        int dp[][] = new int[length.length + 1][rodLen + 1];
        // step 2 initialize and meaning assign ;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // i == price and j == length ;
                if (length[i - 1] <= j) { // vaild condtion
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else { // invalild condition
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[price.length][rodLen];
    }
}