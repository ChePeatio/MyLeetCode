package com.chepeatio.copyListWithRandomPointer;

/**
 * Created by Che Peatio on 2015/11/2.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result = new RandomListNode(head.label);

        RandomListNode temp = head;
        RandomListNode res = result;
        while (temp.next != null) {
            RandomListNode rln = new RandomListNode(temp.next.label);
            res.next = rln;
            res = res.next;
            temp = temp.next;
        }
        return result;
    }
}
