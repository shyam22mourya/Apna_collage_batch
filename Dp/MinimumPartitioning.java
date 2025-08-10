package Dp;

import java.util.Arrays;

public class MinimumPartitioning {
    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum = Math.abs(sum + i);
        }
        int w = sum / 2;
        // 0-1 Knapsap code
        // create table
        int dp[][] = new int[n + 1][w + 1];
        // fill table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int value = nums[i - 1];
                int wt = nums[i - 1];
                if (wt <= j) {
                    int inc = value + dp[i - 1][j - wt];
                    int exl = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exl);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static int miniJump(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };
        System.out.println(miniJump(arr));
    }

}
