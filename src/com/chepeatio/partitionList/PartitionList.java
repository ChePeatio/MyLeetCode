package com.chepeatio.partitionList;

import com.chepeatio.utils.ListNode;

public class PartitionList {

    /**
     * the target function for submission of "partition list"
     * 第一次完成时的原始算法，思想是先找到第一个>=x的节点j，标记相关节点后，顺次寻找<x的节点，并加入到j节点之前
     * 提交失败原因：没有判断head为null的情况
     * 问题：没有设置链表头节点索引，导致判断时需要区分两种情况
     * @param head
     * @param x
     * @return
     */
    public ListNode Partition_original(ListNode head, int x) {

        if (head == null)
            return null;

        ListNode flagNode = head; // flag node for traversing the node list
        ListNode tempNode; // temp node for changing the node list
        ListNode beforeBigNode = null; // the node before the leftest node(>=x)

        if (head.val >= x) {
            ListNode newHeadNode = head;
            while (flagNode.next != null) {
                if (flagNode.next.val < x) {
                    tempNode = flagNode.next;
                    flagNode.next = tempNode.next;
                    tempNode.next = head;

                    if (beforeBigNode == null) {
                        beforeBigNode = tempNode;
                        newHeadNode = tempNode;
                    } else {
                        beforeBigNode.next = tempNode;
                        beforeBigNode = beforeBigNode.next;
                    }
                } else {
                    flagNode = flagNode.next;
                }
            }
            return newHeadNode;
        } else {
            beforeBigNode = head;
            while (beforeBigNode.next!=null && beforeBigNode.next.val<x) {
                beforeBigNode = beforeBigNode.next;
            }
            if (beforeBigNode.next != null) {
                flagNode = beforeBigNode.next;
                while (flagNode.next != null) {
                    if (flagNode.next.val < x) {
                        tempNode = flagNode.next;
                        flagNode.next = tempNode.next;
                        tempNode.next = beforeBigNode.next;
                        beforeBigNode.next = tempNode;
                        beforeBigNode = beforeBigNode.next;
                    }
                    else {
                        flagNode = flagNode.next;
                    }
                }
            }
            return head;
        }
    }

    /**
     * 本解法思想和原始解法相同，不同点是自建了newHead节点，从而将原始解法中的是否为头部的判断省去，缩减代码规模
     * @param head
     * @param x
     * @return
     */
    public ListNode PartitionNS(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode flagNode = newHead;
        ListNode insertNode;
        ListNode tempNode;

        while (flagNode.next!=null && flagNode.next.val<x) {
            flagNode = flagNode.next;
        }

        if (flagNode.next != null) {
            insertNode = flagNode;

            while (flagNode.next != null) {
                if (flagNode.next.val < x) {
                    tempNode = flagNode.next;
                    flagNode.next = tempNode.next;
                    tempNode.next = insertNode.next;
                    insertNode.next = tempNode;
                    insertNode = insertNode.next;
                } else {
                    flagNode = flagNode.next;
                }
            }
        }
        return newHead.next;
    }

    /**
     * 本解法目前最好，将所有<x的节点取出组成新的链表，则剩下的节点的值都应>=x,因此只要将原链表接在新链表后即可
     * @param head
     * @param x
     * @return
     */
    public ListNode PartitionBS(ListNode head, int x) {
        ListNode newHead = new ListNode(-1); // new head that will not present in the result
        ListNode leftHead = new ListNode(-1); // the head of the list bigger than x
        leftHead.next = head;

        ListNode tempNode = leftHead;
        ListNode preNode = newHead;
        while (tempNode.next != null) {
            if (tempNode.next.val < x) {
                preNode.next = tempNode.next;
                preNode = preNode.next;
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }

        preNode.next = leftHead.next;

        return newHead.next;
    }
}
