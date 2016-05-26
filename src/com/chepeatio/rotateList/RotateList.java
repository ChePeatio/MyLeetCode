package com.chepeatio.rotateList;

import com.chepeatio.utils.ListNode;

import java.util.ArrayList;

/**
 * Created by Che Peatio on 2016/5/26.
 */
public class RotateList {

    /**
     * This solution used an ArrayList to index the ListNodes,
     * while the test case may be too small, so the acceleration of the trick is not clear.
     * @param head of ListNodes
     * @param k rotate number
     * @return new list
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode res = new ListNode(0);
        res.next = head;
        if (head != null && head.next !=null) {
            ListNode temp = head;
            ArrayList<ListNode> al = new ArrayList<>();
            while (temp != null) {
                al.add(temp);
                temp = temp.next;
            }
            int len = al.size();
            k = k % len;
            int index = len - k;
            if (k > 0 && index > 0) {
                temp = al.get(index - 1);
                res.next = temp.next;
                temp.next = null;
                al.get(len - 1).next = head;
            }
        }
        return res.next;
    }
}
