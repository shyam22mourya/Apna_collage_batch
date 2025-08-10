package Dp;

public class dp1 {

    // using recurion
    public static int fibu(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibu(n - 1) + fibu(n - 2);
    }

    // using memoization
    public static int fibuMemo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibuMemo(n - 1, dp) + fibuMemo(n - 2, dp);
        return dp[n];
    }

    // using tabulation ;
    public static int fiduTadu(int n) {
        // intialize
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        // int dp[] = new int[n + 1];
        ClimintsSairs cl = new ClimintsSairs();
        System.out.println(cl.climbTudo(n));
    }
}

class ClimintsSairs {
    public int climb(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climb(n - 1) + climb(n - 2) + climb(n - 3);
    }

    // for n-1 , n-2 , n-3 ;
    public int climbMemo(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climb(n - 1) + climb(n - 2) + climb(n - 3);
        return dp[n];
    }

    public int climbTudo(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        if (n < 0) {
            dp[n] = 0;
        }
        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
}