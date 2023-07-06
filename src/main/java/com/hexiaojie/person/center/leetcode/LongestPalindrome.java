package com.hexiaojie.person.center.leetcode;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 暴力解法
     * @param s
     * @return
     */
    private static String longestPalindrome(String s){
            int maxLen = 0;
            int startPos = 0;
            for (int i = 0; i < s.length(); ++i) {
                int halfLen = 0;
                while (i+halfLen+1<s.length()
                        && i-halfLen-1>=0
                        && s.charAt(i+halfLen+1) == s.charAt(i-halfLen-1)) {
                    halfLen++;
                }
                if (halfLen*2+1 > maxLen) {
                    maxLen = halfLen*2+1;
                    startPos = i-halfLen;
                }

                halfLen = 0;
                while (i+halfLen+1<s.length() && i-halfLen>=0
                        && s.charAt(i+halfLen+1) == s.charAt(i-halfLen)) {
                    halfLen++;
                }
                if (halfLen*2 > maxLen) {
                    maxLen = halfLen*2;
                    startPos = i-halfLen+1;
                }
            }
            return s.substring(startPos, startPos+maxLen);
    }

    private static boolean isPailndrome(char[] chars, int left, int right){
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


    private static String longestPalindromeCenter(String s){
        int length = s.length();
        if(length < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < length - 1; i++){
            int oddLen = expendAroundCenter(chars,i, i);
            int evenLen = expendAroundCenter(chars,i, i+1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if(curMaxLen > maxLen){
                maxLen = curMaxLen;
                //这一步要在纸上画图发现规律
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }


    private static int expendAroundCenter(char[] chars, int left, int right){
        int len = chars.length;
        int i = left;
        int j = right;

        while(i >=0 && j <len){
            if(chars[i] == chars[j]){
                i++;
                j++;
            }else{
                break;
            }
        }
        //跳出while循环时，恰好满足s.chatAt(i) !=s,charAt(j),
        //回文串的长度是 j - i + 1 -2 = j + i - 1

        return j - i -1;
    }


    private static String longestPalindromeDp(String s){
        int length = s.length();
        if(length < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        //dp[i][j]表示s[i,,j]是否 是回文串
        boolean[][] dp = new boolean[length][length];

        for(int i =0; i <length; i++){
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        //注意左下角先填
        for(int j = 1; j < length; j++){
            for(int i =0; i < j; i ++){
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //只要dp[i][j] == true成立，就表示子串s[i,,j]是回文，此时记录回文长度和其实位置
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - j + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
