package com.chepeatio.reverseLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/1.
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

    public ListNode generateList(int[] arr) {
        if (arr.length==0 || arr==null)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public int[] listnodeToArray(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
