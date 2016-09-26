package com.chepeatio.swapNodesInPairs;

import com.chepeatio.utils.ListNode;

/**
 * Created by Che Peatio on 2015/12/3.
 * Edited by Che Peatio on 2016/05/02.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode ln1, temp;
        ln1 = res;
        while (ln1.next!=null && ln1.next.next!=null) {
            temp = ln1.next;
            ln1.next = ln1.next.next;
            temp.next = ln1.next.next;
            ln1.next.next = temp;
            ln1 = temp;
        }
        return res.next;
    }
}
