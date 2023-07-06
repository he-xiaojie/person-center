package com.hexiaojie.person.center.leetcode;

public class ClimbStairs {
    /**
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * f(n) = f(1) + f(2)
     *
     */

    public static void main(String[] args) {

    }

    private static int climbStairs(int n){
        if(n <= 2){
           return n;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <=n ; i++){
            dp[i] = dp[i -1] + dp[i -2];
        }

        return dp[n];
    }
}
