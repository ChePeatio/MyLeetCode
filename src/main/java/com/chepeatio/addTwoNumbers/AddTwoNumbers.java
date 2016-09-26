package com.chepeatio.addTwoNumbers;

/**
 * Created by Che Peatio on 2015/11/8.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode res = result;
        while (temp1 != null && temp2 != null) {
            int val = temp1.val + temp2.val + carry;
            ListNode pos;
            if (val > 9) {
                pos = new ListNode(val - 10);
                carry = 1;
            } else {
                pos = new ListNode(val);
                carry = 0;
            }
            res.next = pos;
            res = res.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 == null) {
            res.next = temp2;
            while (res.next != null) {
                int val = res.next.val + carry;
                if (val > 9) {
                    res.next.val = val - 10;
                    carry = 1;
                } else {
                    res.next.val = val;
                    carry = 0;
                    break;
                }
                res = res.next;
            }
        } else {
            res.next = temp1;
            while (res.next != null) {
                int val = res.next.val + carry;
                if (val > 9) {
                    res.next.val = val - 10;
                    carry = 1;
                } else {
                    res.next.val = val;
                    carry = 0;
                    break;
                }
                res = res.next;
            }
        }
        if (carry == 1) {
            res.next = new ListNode(carry);
        }

        return result.next;
    }
}
