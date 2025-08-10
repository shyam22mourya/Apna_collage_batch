package Dp;

public class Knapsack {
    // Using recursion
    public static int knapsack(int val[], int wt[], int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        // valid
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, w, n - 1);
            return Math.max(ans1, ans2);
        } else { // not valid
            return knapsack(val, wt, w, n - 1);
        }
    }

    // Using memoization

    public static int knapsackMemo(int val[], int wt[], int w, int n, int dp[][]) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        // valid
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, w, n - 1);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else { // not valid
            dp[n][w] = knapsack(val, wt, w, n - 1);
            return dp[n][w];
        }
    }

    public static int knapsackTadu(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; //
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][1] = 0; //
        }

        for (int i = 1; i < dp.length; i++) { // i== number of items
            for (int j = 1; j < dp[0].length; j++) { // j ==weight
                int v = val[i - 1]; // ith item value;
                int w = wt[i - 1];// ith item weight;

                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // invaild
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;

                }
            }
        }
        for (int i = 0; i < dp.length; i++) { // i== number of items
            for (int j = 0; j < dp[0].length; j++) { // j ==weight
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        // int val[] = { 4, 2, 7, 1, 3 };
        // int sum = 4;
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int sum = 7;
      knapsackTadu(val, wt, sum);
    }
}

class TargetSum {

    // using recursion
    public boolean targetSum(int val[], int sum, int index) {
        // base case
        if (sum == 0) {
            return true;
        }
        if (index >= val.length) {
            return false;
        }
        boolean include = targetSum(val, sum - val[index], index + 1);
        boolean exclude = targetSum(val, sum, index + 1);

        return include || exclude;
    }

    // using memoization
    public static boolean targetSum(int val[], int sum, int index, Boolean[][] dp) {
        // Base cases
        if (sum == 0) {
            return true;
        }
        if (index >= val.length || sum < 0) {
            return false;
        }
        // Check if already computed
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }
        // Recursive calls: Include or Exclude the current element
        boolean include = targetSum(val, sum - val[index], index + 1, dp);
        boolean exclude = targetSum(val, sum, index + 1, dp);

        return dp[index][sum] = include || exclude;
    }

    // using tabulation
    public boolean targetSumTabu(int val[], int sum) {
        int n = val.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            // i == items j == sum ;
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}
