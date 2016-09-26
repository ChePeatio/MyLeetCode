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

    public RandomListNode copyRandomListAS(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode result = new RandomListNode(head.label);

        Map<Integer, RandomListNode> mir = new HashMap<>();
        mir.put(head.label, result);

        RandomListNode temp;
        if (head.random != null) {
            if (head.random.label!=head.label) {
                temp = new RandomListNode(head.random.label);
                mir.put(temp.label, temp);
                result.random = temp;
            } else {
                result.random = result;
            }
        }

        temp = head.next;
        RandomListNode res = result;
        while (temp != null) {
            if (mir.containsKey(temp.label)) {
                res.next = mir.get(temp.label);
            } else {
                RandomListNode rln = new RandomListNode(temp.label);
                mir.put(rln.label, rln);
                res.next = rln;
            }

            if (temp.random != null) {
                if (mir.containsKey(temp.random.label)) {
                    res.next.random = mir.get(temp.random.label);
                } else {
                    RandomListNode rln = new RandomListNode(temp.random.label);
                    mir.put(rln.label, rln);
                    res.next.random = rln;
                }
            }

            temp = temp.next;
            res = res.next;
        }
        return result;
    }

    // 算法效率也不是很好，不懂那些2ms的是如何解决的。。。
    public RandomListNode copyRandomListBS(RandomListNode head) {
        if(head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> oldNew = new HashMap<>();

        RandomListNode cur = head;

        RandomListNode dummyNewHead = new RandomListNode(0);
        RandomListNode tail = dummyNewHead;
        while(cur != null) {
            RandomListNode newCopy = new RandomListNode(cur.label);
            tail.next = newCopy;
            tail = tail.next;

            oldNew.put(cur, newCopy);
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                RandomListNode newCur = oldNew.get(cur);
                newCur.random = oldNew.get(cur.random);
            }
            cur = cur.next;
        }
        return dummyNewHead.next;
    }
}
