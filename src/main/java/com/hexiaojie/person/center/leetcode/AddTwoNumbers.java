package com.hexiaojie.person.center.leetcode;


public class AddTwoNumbers {
    public static void main(String[] args) {
        addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(5, null))),
                new ListNode(5, new ListNode(6, new ListNode(4, null)))
                );
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        //进位
        int carry = 0;

        while(p1 != null || p2 != null){
            int sum = 0;
            if(p1 != null){
                sum +=p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                sum +=p2.val;
                p2 = p2.next;
            }
            if(carry != 0){
                sum += carry;
            }

            //sum如果大于10需要进1位
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail =  tail.next;
        }

        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
