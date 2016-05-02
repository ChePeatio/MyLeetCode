package com.chepeatio.reverseNodesInKGroup;

import com.chepeatio.utils.ListNode;

/**
 * Created by Che Peatio on 2016/5/2.
 */
public class ReverseNodesInKGroup {

    /**
     * �ݹ�汾��д�ú�Ư��������
     * @param head ����ͷ��
     * @param k ��ת����
     * @return ��ת���
     */
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    /**
     * ��������İ汾����behindȷ�����η�ת�Ľ��ޣ���before��¼��ʼ��λ��֮ǰ��node����temp��¼��ʼ��node
     * @param head ����ͷ��
     * @param k ��ת����
     * @return ��ת�������
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;
        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode before = beforeHead;
        ListNode behind = before.next;
        ListNode temp = before.next;
        int count = 0;
        while (behind != null) {
            behind = behind.next;
            count++;
            if (count == k) {
                while (temp.next != behind) {
                    ListNode ln = temp.next;
                    temp.next = ln.next;
                    ln.next = before.next;
                    before.next = ln;
                }
                before = temp;
                temp = temp.next;
                count = 0;
            }
        }
        return beforeHead.next;
    }

    /**
     * �ð汾��Ҫ����k�Ŀռ䣬��������ĿҪ�󣬵���AC
     * @param head ����ͷ��
     * @param k ��ת����
     * @return �µ�����
     */
    public ListNode reverseKGroupWithAdditionalSpace(ListNode head, int k) {
        if (k <= 1)
            return head;
        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode before = beforeHead, temp = before.next;
        ListNode[] nodes = new ListNode[k];
        int index = 0;
        while (temp != null) {
            nodes[index] = temp;
            temp = temp.next;
            index++;
            if (index == k) {
                for (int i=k-1; i>0; i--) {
                    nodes[i].next = nodes[i-1];
                }
                nodes[0].next = temp;
                before.next = nodes[k-1];
                before = nodes[0];
                index = 0;
            }
        }

        return beforeHead.next;
    }
}
