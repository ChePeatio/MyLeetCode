package com.chepeatio.copyListWithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Che Peatio on 2015/11/2.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode result = new RandomListNode(head.label);

        List<Long> randomLabel = new ArrayList<>();
        if (head.random != null) {
            randomLabel.add((long)head.random.label);
        } else {
            randomLabel.add(Long.MAX_VALUE);
        }

        Map<Integer, RandomListNode> mapToNode = new HashMap<>();
        mapToNode.put(result.label, result);


        RandomListNode temp = head.next;
        RandomListNode res = result;
        while (temp != null) {
            RandomListNode rln = new RandomListNode(temp.label);
            mapToNode.put(rln.label, rln);
            if (temp.random != null) {
                randomLabel.add((long)temp.random.label);
            } else {
                randomLabel.add(Long.MAX_VALUE);
            }
            res.next = rln;
            res = res.next;
            temp = temp.next;
        }

        int i=0;
        long sp;
        res = result;
        while (res != null) {
            sp = randomLabel.get(i);
            if (sp == Long.MAX_VALUE) {
                res.random = null;
            } else {
                res.random = mapToNode.get((int)sp);
            }
            res = res.next;
            i++;
        }
        return result;
    }
}
