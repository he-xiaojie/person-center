package com.hexiaojie.person.center.leetcode;

import com.hexiaojie.person.center.leetcode.ListNode;

public class Test1 {

    public static void main(String[] args) {
        /**
         * [1,3,2,4] 变成[1,2,3,4]
         *
         */
        ListNode head = new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(2))));
        ListNode listNode = mergeSortList(head);
        System.out.println(listNode);
    }

    private static ListNode mergeSortList(ListNode head){
        /**
         * 采用分治的思想，用递归的方式实现
         */
        if(head == null || head.next == null){
            return head;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode nextNode = middleNode.next;
        middleNode.next = null;
        ListNode leftHead = mergeSortList(head);
        ListNode rightHead = mergeSortList(nextNode);
        return mergeList(leftHead, rightHead);
    }

    private static ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        /**
         * 利用虚拟头节点来合并链表
         *
         */
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode pa = leftHead;
        ListNode pb = rightHead;
        while(pa != null && pb != null){
            if(pa.val <= pb.val){
                tail.next = pa;
                tail = tail.next;
                pa = pa.next;
            }else{
                tail.next = pb;
                tail = tail.next;
                pb = pb.next;
            }
        }

        if(pa != null){
            tail.next = pa;
        }
        if(pb != null){
            tail.next = pb;
        }
        return newHead.next;
    }

    private static ListNode findMiddleNode(ListNode head){
        /**
         * 快慢指针找中间的节点
         */
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
