package com.hexiaojie.person.center.leetcode;

public class RemoveElements {

    public ListNode removeElement1(ListNode head, int val){
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;

        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return newHead.next;
    }

    public ListNode removeElement2(ListNode head, int val){

        ListNode newHead = new ListNode();
        //新链表的尾部
        ListNode tail = newHead;
        // 遍历原始链表
        ListNode p = head;

        while(p != null){
            ListNode tmp = p.next;
            if(p.val != val){
                //从原先链表摘掉
                p.next = null;
                //往后移动一位
                tail.next = p;
                //tail指向p
                tail = p;
            }
            p = tmp;
        }
        return newHead.next;
    }

}
