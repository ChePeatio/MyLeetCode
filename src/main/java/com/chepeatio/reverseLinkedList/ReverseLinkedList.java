package com.chepeatio.reverseLinkedList;

import com.chepeatio.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/1.
 * Edited by Che Peatio on 2016/05/02.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(-1);

        if (head == null)
            return result.next;

        result.next = head;
        ListNode temp = head.next;
        while (temp != null) {
            head.next = temp.next;
            temp.next = result.next;
            result.next = temp;
            temp = head.next;
        }
        return result.next;
    }
}
