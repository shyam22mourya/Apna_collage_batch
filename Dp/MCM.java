package Dp;

public class MCM {
    public static int msmRec(int arr[], int i, int j) {
        // base
        if (i == j)
            return 0;
        int minMsM = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = msmRec(arr, i, k);
            int cost2 = msmRec(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int ans = cost1 + cost2 + cost3;
            minMsM = Math.min(minMsM, ans);
        }
        return minMsM;
    }

    public static int msmMemo(int arr[], int i, int j, int dp[][]) {
        // base
        if (i == j)
            return 0;
        int minMsM = Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = i; k <= j - 1; k++) {
            int cost1 = msmMemo(arr, i, k, dp);
            int cost2 = msmMemo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int ans = cost1 + cost2 + cost3;
            minMsM = Math.min(minMsM, ans);
        }
        return dp[i][j] = minMsM;
    }
    public static int msmTabu(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // Initialization: Single matrices have zero multiplication cost
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Filling the DP table bottom-up
        for (int len = 2; len < n; len++) { // Chain length
            for (int i = 1; i <= n - len; i++) { // Row index
                int j = i + len - 1; // Column index
                dp[i][j] = Integer.MAX_VALUE;
                
                // Finding minimum cost
                for (int k = i; k < j; k++) {
                    int cost1 = dp[i][k]; // Left half
                    int cost2 = dp[k + 1][j]; // Right half
                    int cost3 = arr[i - 1] * arr[k] * arr[j]; // Multiplication cost
                    int ans = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(ans, dp[i][j]);
                }
            }
        }
        
        // Print DP Table (Optional)
        print(dp);
        
        return dp[1][n - 1];
    }
    
    public static void print(int dp[][]) {
        for (int[] a : dp) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }   

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int[] a : dp) {
            for (int i = 0; i < a.length; i++) {
                a[i] = -1;
            }
        }

        System.out.println(msmTabu(arr));
    }
}
