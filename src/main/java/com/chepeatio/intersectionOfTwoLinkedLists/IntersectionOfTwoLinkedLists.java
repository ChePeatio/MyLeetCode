package com.chepeatio.intersectionOfTwoLinkedLists;

import java.util.HashSet;

/**
 * Created by Che Peatio on 2016/1/13.
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * The most beautiful solution, which is simple, efficient and easy to understand.
     * @param headA node 1
     * @param headB node 2
     * @return intersection node
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a==null ? headB : a.next;
            b = b==null ? headA : b.next;
        }
        return a;
    }

    /**
     * Normal solution, while I did not find it!T_T
     * @param headA node 1
     * @param headB node 2
     * @return intersection node
     */
    public ListNode getIntersectionNodeNormalSolution(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode temp = headA;
        while (temp != null) {
            temp = temp.next;
            lenA++;
        }
        temp = headB;
        while (temp != null) {
            temp = temp.next;
            lenB++;
        }
        int diff = lenA - lenB;
        if (diff >= 0) {
            temp = headA;
            while (diff > 0) {
                temp = temp.next;
                diff--;
            }
            ListNode temp2 = headB;
            while (temp != temp2) {
                temp = temp.next;
                temp2 = temp2.next;
            }
        } else {
            temp = headB;
            while (diff < 0) {
                temp = temp.next;
                diff++;
            }
            ListNode temp2 = headA;
            while (temp != temp2) {
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        return temp;
    }

    /**
     * Most ugly code! And I can only use it solve the problem, how ashamed!
     * @param headA node 1
     * @param headB node 2
     * @return intersection node
     */
    public ListNode getIntersectionNodePoorSolution(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (!hashSet.add(temp))
                return temp;
            temp = temp.next;
        }
        return null;
    }
}
