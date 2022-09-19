package com.questioncomparer;

public class Comparator {
    public static double editDistance(String a, String b) {
        int n = a.length(), m = b.length(), big = (int)1e9;
        int[][] dp = new int[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++)
            for (int j = 0; j < m + 2; j++)
                dp[i][j] = big;

        for (int i = n; i >= 0; i--)
            for (int j = m; j >= 0; j--)
                if (i == n && j == m)
                    dp[i][j] = 0;
                else if (i == n)
                    dp[i][j] = 1 + dp[i][j + 1];
                else if (j == m)
                    dp[i][j] = 1 + dp[i + 1][j];
                else {
                    int delete = 1 + dp[i + 1][j];
                    int insert = 1 + dp[i][j + 1];
                    int replace = 1 + dp[i + 1][j + 1];

                    if (a.charAt(i) == b.charAt(j))
                        dp[i][j] = dp[i + 1][j + 1];
                    dp[i][j] = Math.min(Math.min(dp[i][j], delete), Math.min(insert, replace));
                }
        return dp[0][0];
    }
    //calculates how much % needed to change the longer string into the shorter
    static double similarity(String a, String b) {
        int mx = Math.max(a.length(), b.length());
        return (1 - (double)(editDistance(a, b)) / mx) * 100;
    }
}