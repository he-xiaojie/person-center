package com.hexiaojie.person.center.leetcode;

public class MiddleNode {

    public static void main(String[] args) {
        System.out.println(middleNode(
                new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
