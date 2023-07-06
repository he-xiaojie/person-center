package com.hexiaojie.person.center.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindrome {

    public static void main(String[] args) {
        int x = 1234321;
        System.out.println(isPalindrome(x));
    }

    private static Boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int backupx = x;
        //y为x反转之后的值
        int y = 0;
        while( x != 0){
            y = y*10 + x % 10;
            x = x / 10;
        }

        return backupx == y;
    }

    private static Boolean isPalindrome(ListNode head){
        List<Integer>  list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int j = size -1;
        //双指针判断是否是回文串
        for (int i =0; i < size/2; i++){
            if(!Objects.equals(list.get(i), list.get(j))){
                return false;
            }
            j--;
        }
        return true;
    }
}

