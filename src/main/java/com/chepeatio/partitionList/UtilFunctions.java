package com.chepeatio.partitionList;

/**
 * Created by CheKedar on 2015/10/19.
 */
public class UtilFunctions {
    /**
     * using an array of integer to create a list of ListNode
     * @param list is an array of integer
     * @return
     */
    public static ListNode generateListNode(int[] list) {

        if (list==null || list.length==0)
            return null;

        ListNode head = new ListNode(list[0]);
        ListNode preNode = head;
        for (int i=1; i<list.length; i++) {
            ListNode newNode = new ListNode(list[i]);
            preNode.next = newNode;
            preNode = newNode;
        }

        return head;
    }



    public static void displayListContent(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.val + " ");
            tempNode = tempNode.next;
        }
    }
}
