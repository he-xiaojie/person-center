package com.hexiaojie.person.center.leetcode;

public class ReverseList {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        //头插法
        ListNode newHead = null;
        ListNode p = head;
        while(p != null){
            ListNode next = p.next;
            p.next = newHead;
            newHead = p;
            p = next;
        }
        return newHead;
    }
}
