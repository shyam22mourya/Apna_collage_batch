package Dp;

public class EditDistance {

    public static int editDisRecu(String word1, String word2, int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (word1.charAt(i) != word2.charAt(j)) {
            int add = editDisRecu(word1, word2, i, j - 1);
            int dele = editDisRecu(word1, word2, i - 1, j);
            int rep = editDisRecu(word1, word2, i - 1, j - 1);

            return Math.min(add, Math.min(dele, rep)) + 1;
        }
        return editDisRecu(word1, word2, i - 1, j - 1);
    }

    public static int editDisMemo(String word1, String word2, int i, int j, int dp[][]) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) != word2.charAt(j)) {
            int add = editDisMemo(word1, word2, i, j - 1, dp);
            int dele = editDisMemo(word1, word2, i - 1, j, dp);
            int rep = editDisMemo(word1, word2, i - 1, j - 1, dp);

             return dp[i][j] = Math.min(add, Math.min(dele, rep)) + 1;
        }
        return dp[i][j] = editDisRecu(word1, word2, i - 1, j - 1);
    }

    public static int editDisTabu(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // step 1 create table
        int dp[][] = new int[n + 1][m + 1];
        // step 2 intialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // fill bottom up manner
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // same
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = Math.min(add, Math.min(delete, replace)) + 1;
                }
            }
        }
        return dp[n][m];
    }

    public static int[] StringCon(String word1, String word2) {
        int lcs = lcs(word1, word2); // longest common subsequence
        int delete = Math.abs(word1.length() - lcs);
        int add = Math.abs(word2.length() - lcs);
        return new int[] { delete, add };
    }

    public static int lcs(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // step 1 creat table
        int dp[][] = new int[n + 1][m + 1];
        // step2 intialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // step 3 fill value ;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

        String word1 = "aocfe";
        String word2 = "acde";
        int arr[] = StringCon(word1, word2);
        System.out.printf("delete itme %d  and add items %d", arr[0], arr[1]);
    }
}