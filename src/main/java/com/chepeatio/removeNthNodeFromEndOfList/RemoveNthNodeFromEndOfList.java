package com.chepeatio.removeNthNodeFromEndOfList;

import com.chepeatio.utils.ListNode;

/**
 * Created by Che Peatio on 2016/1/22.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEndOnePassSolution(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    /**
     * My solution with two passes, while I think one pass solution just like my solution...
     * @param head head of the list
     * @param n nth node from end
     * @return other nodes
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = nHead;
        while (count > n) {
            temp = temp.next;
            count--;
        }
        temp.next = temp.next.next;
        return nHead.next;
    }
}
