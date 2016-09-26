package com.chepeatio.mergeTwoSortedLists;

/**
 * Created by Che Peatio on 2015/11/30.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1!=null && temp2!=null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        while (temp1!=null) {
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;
        }
        while (temp2!=null) {
            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return res.next;
    }
}
