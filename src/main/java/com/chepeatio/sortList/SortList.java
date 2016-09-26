package com.chepeatio.sortList;

import com.chepeatio.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/6.
 * Edited by Che Peatio on 2016/05/02.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }

        //Use two runners to break list into two halfs.
        ListNode fast = head, slow = head, prev = head;
        while (fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = prev.next;
        prev.next = null;
        //sort each half
        ListNode first = sortList(head);
        second = sortList(second);
        //merge them.
        head = mergeList(first, second);
        return head;
    }

    private ListNode mergeList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0), merged = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                merged.next = first;
                merged = merged.next;
                first = first.next;
            } else {
                merged.next = second;
                merged = merged.next;
                second = second.next;
            }
        }
        if (first != null || second != null)
            merged.next = (first != null) ? first :second;

        return dummy.next;
    }

    public ListNode sortListTLE(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        partSortList(result, head);
        return result.next;
    }

    public void partSortList(ListNode beforeHead, ListNode head) {
        if (head==null || head.next==null)
            return;

        ListNode ln = head;
        ListNode temp = ln.next;
        while (temp != null) {
            if (temp.val < head.val) {
                ln.next = temp.next;
                temp.next = beforeHead.next;
                beforeHead.next = temp;
                temp = ln.next;
            } else {
                ln = temp;
                temp = temp.next;
            }
        }

        if (beforeHead.next != head)
            partSortList(beforeHead, beforeHead.next);
        partSortList(head, head.next);
    }

    public ListNode generateList(int[] array) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int value : array) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return result.next;
    }

    public int[] listToArray(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            res.add(temp.val);
            temp = temp.next;
        }
        int[] result = new int[res.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
