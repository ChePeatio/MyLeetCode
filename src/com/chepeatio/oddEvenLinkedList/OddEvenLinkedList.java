package com.chepeatio.oddEvenLinkedList;

/**
 * Created by Che Peatio on 2016/1/18.
 */
public class OddEvenLinkedList {
    /**
     * The most difficult problem is understanding the problem...T_T
     * @param head of list
     * @return new head of new list
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(1);
        ListNode evenHead = new ListNode(2);
        ListNode oddTemp = oddHead;
        ListNode evenTemp = evenHead;
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            if ((count & 1) == 1) {
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            } else {
                evenTemp.next = temp;
                evenTemp = evenTemp.next;
            }
            temp = temp.next;
            count++;
        }
        oddTemp.next = null;
        evenTemp.next = oddHead.next;
        return evenHead.next;
    }

    public ListNode generateList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return head.next;
    }

    public void displayList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
