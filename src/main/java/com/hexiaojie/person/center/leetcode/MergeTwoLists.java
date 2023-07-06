package com.hexiaojie.person.center.leetcode;

public class MergeTwoLists {
    /**
     * Definition for singly-linked list.

     */
    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 虚拟头节点
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode();
        ListNode tail = head;

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            }else{
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }

        if(p1 == null){
            tail.next = p2;
        }

        if(p2 == null){
            tail.next = p1;
        }
        return head.next;

    }




}
