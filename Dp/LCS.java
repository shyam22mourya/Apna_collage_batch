package Dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LCS { // Longest common subsequence
    // using recurtion
    public static int lcs(String str1, String str2, int n, int m) {
        // base case
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else { // diff
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    // using recursion + memoization
    public static int lcs(String str, String str2) {
        int n = str.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return helper(str, str2, dp, n, m);
    }

    public static int helper(String str, String str2, int[][] dp, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = helper(str, str2, dp, n - 1, m - 1) + 1;
        } else {
            int ans1 = helper(str, str2, dp, n - 1, m);
            int ans2 = helper(str, str2, dp, n, m - 1);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    // using tabulation
    public static int lcsTadu(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LIS li = new LIS();
        int[] arr = { 1, 101, 2, 3, 100 };
        System.out.println(li.lisTabu(arr));
        
        String str1 = "abcdge";
        String str2 = "abg";
        System.out.println(lcsTadu(str1, str2));
    }
}

class LIS { // longest increating subsequence
    public int lisTabu(int arr[]) {
        // step1 creat hashSet ; unique elements
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        // Step2 sort
        int copy[] = new int[set.size()];
        int j = 0;
        for (int i : set) {
            copy[j++] = i;
        }
        Arrays.sort(copy);
        return lonCommSeq(arr, copy);
    }

    public int lonCommSeq(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        // step1 creat
        int dp[][] = new int[n + 1][m + 1];

        // step2 intialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        // step3 fill table bottom-Up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    // Longest commom SubString ;v
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}