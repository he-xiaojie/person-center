package com.hexiaojie.person.center.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


    private static int lengthOfLongestSubstring(String s){
        /**
         * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
         */
        int length = s.length();
        if(length == 0){
            return 0;
        }
        int p = 0;
        int q = 0;

        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        while(q < length){
            char c = s.charAt(q);
            if(!set.contains(c)){
                set.add(c);
                q++;
                if(q - p +1 > maxLen){
                    maxLen = q - p +1;
                }
                continue;
            }
            while(set.contains(c)){
               //删除c前面的元素
               set.remove(s.charAt(p));
               p++;
            }
        }
        return maxLen;
    }
}
