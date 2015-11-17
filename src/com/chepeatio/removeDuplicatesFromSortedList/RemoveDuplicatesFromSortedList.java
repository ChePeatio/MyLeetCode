package com.chepeatio.removeDuplicatesFromSortedList;

import java.util.ArrayList;

/**
 * Created by Che Peatio on 2015/11/17.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resist = head;
        while (resist.next != null) {
            if (resist.val == resist.next.val) {
                resist.next = resist.next.next;
            } else {
                resist = resist.next;
            }
        }
        return head;
    }

    public ListNode generateList(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int num : array) {
            ListNode ln = new ListNode(num);
            temp.next = ln;
            temp = temp.next;
        }
        return head.next;
    }

    public int[] getArray(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            al.add(temp.val);
            temp = temp.next;
        }
        int[] nums = new int[al.size()];
        for (int i=0; i<nums.length; i++) {
            nums[i] = al.get(i);
        }
        return nums;
    }
}
