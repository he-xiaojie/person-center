package com.hexiaojie.person.center.leetcode;

public class ReverseBetween {
    public static void main(String[] args) {
        System.out.println(reverseBetween(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5,null))))), 2, 4).toString());
    }


    public static ListNode reverseBetween(ListNode head, int left, int right){
        /**
         * 遍历链表，到left个节点后，开始头插法。知道right节点后，改为尾插法
         */

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        for(int i =0; i<left -1; i ++){
            pre = pre.next;
        }
        //后面的元素往这个前面插入
        ListNode newHeadNode = pre.next;
        ListNode next;
        for(int i =0; i < right -left; i++){
            //临时node
            next = pre.next;
            newHeadNode.next = next.next;
            next =
            pre = newHeadNode;

        }

        return newHead.next;
    }
}
