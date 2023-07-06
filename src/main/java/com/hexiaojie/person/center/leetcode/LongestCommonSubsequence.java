package com.hexiaojie.person.center.leetcode;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public static int longestCommonSubsequence(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text1.toCharArray();
        //dp[i][j]表示text1[0~i-1](长度为i的子串)和text2(0~j-1)(长度为j的子串)的LCS
        int dp[][] = new int[n+1][m+1];
        for(int j = 0; j <=m; j++){
            dp[0][j] = 0;
        }

        for(int i =0; i <=n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=m; j++){
                if(t1[i -1] == t2[j-1]){
                    dp[i][j] = max3(dp[i -1][j -1] +1, dp[i-1][j], dp[i][j -1]);
                }else{
                    dp[i][j] = max3(dp[i -1][j -1], dp[i-1][j], dp[i][j -1]);
                }
            }
        }
        return dp[n][m];
    }

    private static int max3(int a, int b, int c){
        int maxv = a;
        if(maxv < b){
          maxv = b;
        }
        if(maxv < c){
            maxv = c;
        }
        return maxv;
    }

}
