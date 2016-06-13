package com.chepeatio.reverseLinkedList;

import com.chepeatio.utils.ListNode;

/**
 * Created by Che Peatio on 2016/6/13.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode startPos = newHead, reversePos, temp;
        int i = 1;
        while (i < m) {
            startPos = startPos.next;
            i++;
        }
        reversePos = startPos.next;
        temp = reversePos.next;
        while (i < n) {
            reversePos.next = temp.next;
            temp.next = startPos.next;
            startPos.next = temp;
            temp = reversePos.next;
            i++;
        }
        return newHead.next;
    }
}
