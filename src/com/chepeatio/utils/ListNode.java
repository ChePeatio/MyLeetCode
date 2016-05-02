package com.chepeatio.utils;

/**
 * Created by Che Peatio on 2016/5/1.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode generateList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        if (array==null || array.length==0)
            return null;
        else {
            for (int value : array) {
                temp.next = new ListNode(value);
                temp = temp.next;
            }
            return head.next;
        }
    }

    public static boolean compareTwoLists(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        ListNode t2 = head2;
        boolean te = true;
        while (te && t1 != null) {
            if (t2 != null && t1.val == t2.val) {
                t1 = t1.next;
                t2 = t2.next;
            } else {
                te = false;
            }
        }
        return te && t2==null;
    }

    public String getValList() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        return sb.toString();
    }
}
