package com.chepeatio.partitionList;

import com.chepeatio.utils.ListNode;

public class PartitionList {

    /**
     * the target function for submission of "partition list"
     * ��һ�����ʱ��ԭʼ�㷨��˼�������ҵ���һ��>=x�Ľڵ�j�������ؽڵ��˳��Ѱ��<x�Ľڵ㣬�����뵽j�ڵ�֮ǰ
     * �ύʧ��ԭ��û���ж�headΪnull�����
     * ���⣺û����������ͷ�ڵ������������ж�ʱ��Ҫ�����������
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
     * ���ⷨ˼���ԭʼ�ⷨ��ͬ����ͬ�����Խ���newHead�ڵ㣬�Ӷ���ԭʼ�ⷨ�е��Ƿ�Ϊͷ�����ж�ʡȥ�����������ģ
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
     * ���ⷨĿǰ��ã�������<x�Ľڵ�ȡ������µ�������ʣ�µĽڵ��ֵ��Ӧ>=x,���ֻҪ��ԭ�������������󼴿�
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
