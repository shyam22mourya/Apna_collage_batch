package Dp;

public class Pattern {
    public static boolean wildPattern(String word, String pattern) {
        // create table
        int n = word.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        // step 2 intialize
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < m + 1; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // Step 3 creat table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') { // dp[i-1][j] == ignore || dp[i][j-1] == maching
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else { 
                    dp[i][j] = false;
                }

            }
        }
        return dp[n][m];
    }

    public static boolean wildPatternRecu(String word, String pattern, int i, int j) {
        // Base cases
        if (i < 0 && j < 0) {
            return true; // Both strings are fully matched
        }
        if (j < 0) {
            return false; // Pattern exhausted but word still has characters
        }
        if (i < 0) {
            // If only '*' remains in pattern, it can match empty string
            for (int k = 0; k <= j; k++) {
                if (pattern.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        // Matching characters or '?'
        if (word.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
            return wildPatternRecu(word, pattern, i - 1, j - 1);
        }

        // Handling '*'
        if (pattern.charAt(j) == '*') {
            return wildPatternRecu(word, pattern, i - 1, j) || wildPatternRecu(word, pattern, i, j - 1);
        }

        // No match
        return false;
    }
    public static void main(String[] args) {
        String word = "baaabab";
        String pattern = "******ba****ab";
        int n = word.length(); 
        int m  = pattern.length();
        System.out.println(wildPatternRecu(word , pattern , n-1 ,m-1));
    }

}