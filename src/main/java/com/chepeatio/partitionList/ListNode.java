package com.chepeatio.partitionList;

/**
 * Created by CheKedar on 2015/10/18.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}

    public String getValList() {
        StringBuffer sb = new StringBuffer();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val+"");
            temp = temp.next;
        }
        return sb.toString();
    }
}
