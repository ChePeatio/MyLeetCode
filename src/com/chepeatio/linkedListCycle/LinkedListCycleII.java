package com.chepeatio.linkedListCycle;

/**
 * Created by Che Peatio on 2015/12/27.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode twoStep = head.next.next;
        ListNode oneStep = head.next;
        while (twoStep != oneStep) {
            if (oneStep==null||twoStep==null||twoStep.next==null)
                return null;
            else {
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
            }
        }
        ListNode enterPos = head;
        while (enterPos != oneStep) {
            enterPos = enterPos.next;
            oneStep = oneStep.next;
        }
        return enterPos;
    }
}
