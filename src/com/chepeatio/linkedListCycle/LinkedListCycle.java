package com.chepeatio.linkedListCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/11/5.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                result = true;
                break;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return result;
    }

    public boolean hasCycleBS(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode oneStep = head.next;
        ListNode twoStep = head.next.next;

        while(oneStep!=twoStep){
            if(oneStep==null||twoStep==null) return false;
            if(twoStep.next==null) return false;
            else{
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
            }
        }
        return true;
    }
}
