package com.chepeatio.mergeKSortedLists;

import com.chepeatio.utils.ListNode;

import java.util.PriorityQueue;

/**
 * Created by Che Peatio on 2016/5/1.
 */
public class MergeKSortedLists {

    /**
     * ʹ��java�ṩ��heap��ʵ��TLE�汾���뷨���������˺ܶ࣬��ѧ�Ժܸߣ�
     * �������ݽṹͨ����ǿ��Ч�ʱȽϲ����AC��ʱ��ܳ�
     * @param lists ������Ķ���
     * @return �ںϵĶ���
     */
    public ListNode mergeKListsSimple(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        ListNode head = new ListNode(0), tail = head;

        for (ListNode node : lists)
            if (node != null)
                heap.add(node);

        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            if (heap.size() == 1)
                break;
            tail = tail.next;
            if (tail.next != null)
                heap.add(tail.next);
        }
        return head.next;
    }

    /**
     * ͬTLE�汾��˼�룬ʹ�öѽ�������������ĸ��Ӷȣ���O(n*k)���㷨��Ϊ��O(nlogk)���㷨������n��Ԫ�ظ�����k�Ƕ��и���
     * �������ʵ��Ҳ�Ǻ�easy����
     * @param lists ������Ķ���
     * @return �ںϵĶ���
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode res = new ListNode(0);
        ListNode temp = res;

        int[] hsi = new int[lists.length]; // heap sort indexes
        int len = 0, pos, parentPos;

        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                hsi[len] = i;
                pos = len++;
                parentPos = (pos-1) / 2;
                while (pos != 0 && lists[hsi[parentPos]].val > lists[hsi[pos]].val) {
                    swap(hsi, parentPos, pos);
                    pos = parentPos;
                    parentPos = (pos-1) / 2;
                }
            }
        }

        while (len > 0) {
            temp.next = lists[hsi[0]];
            temp = temp.next;
            if (lists[hsi[0]].next == null) {
                hsi[0] = hsi[len-1];
                len--;
                if (len <= 0)
                    break;
            } else {
                lists[hsi[0]] = lists[hsi[0]].next;
            }

            parentPos = 0;
            if (parentPos*2+2 < len)
                pos = lists[hsi[parentPos*2+1]].val > lists[hsi[parentPos*2+2]].val ? parentPos*2+2 : parentPos*2+1;
            else if (parentPos*2+1 < len)
                pos = parentPos*2+1;
            else
                continue;

            while (lists[hsi[parentPos]].val > lists[hsi[pos]].val) {
                swap(hsi, parentPos, pos);
                parentPos = pos;
                if (parentPos*2+2 < len)
                    pos = lists[hsi[parentPos*2+1]].val > lists[hsi[parentPos*2+2]].val ? parentPos*2+2 : parentPos*2+1;
                else if (parentPos*2+1 < len)
                    pos = parentPos*2+1;
                else
                    break;
            }
        }

        return res.next;
    }

    /**
     * TLE version�������뷨������һ�������¼��ǰlistsͷ����������Ϣ��
     * ÿ�β�����С��node���ٴθ������顣
     * ������+����ʹ�õ��Ǳ����ķ�ʽ��Ч��̫�͡�
     * @param lists ������Ķ���
     * @return �����Ķ���
     */
    public ListNode mergeKListsTLE(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        else if (lists.length == 1)
            return lists[0];

        int begin = 0;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int[] sortIndexes = new int[lists.length];
        for (int i=0; i<lists.length; i++) {
            sortIndexes[i] = i;
            if (lists[sortIndexes[begin]] == null)
                begin++;
            for (int j=i; j>begin; j--) {
                if (lists[sortIndexes[j]] == null) {
                    swap(sortIndexes, j, j-1);
                }
                else if (lists[sortIndexes[j]].val < lists[sortIndexes[j-1]].val) {
                    swap(sortIndexes, j, j-1);
                } else {
                    break;
                }
            }
        }
        if (begin < lists.length && lists[sortIndexes[begin]] == null)
            begin++;

        int index;
        while (begin < lists.length) {
            index = sortIndexes[begin];
            temp.next = lists[index];
            temp = temp.next;
            if (lists[index].next==null) {
                begin++;
            }
            else {
                lists[index] = lists[index].next;
                for (int i=begin; i<lists.length-1; i++) {
                    if (lists[sortIndexes[i]].val > lists[sortIndexes[i+1]].val) {
                        swap(sortIndexes, i, i+1);
                    } else {
                        break;
                    }
                }
            }
        }

        return res.next;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * �����㷨��ʱ�临�Ӷ������Ҳ��O(nlogk)
     * @param lists ������Ķ���
     * @return �ںϵĶ���
     */
    public ListNode mergeKListsMC(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return mergeSort(lists, 0, lists.length-1);
    }

    private ListNode mergeSort(ListNode[] lists, int low, int high){
        if(low == high){
            return lists[low];
        }
        else{
            int mid=(low+high)/2;
            ListNode h1=mergeSort(lists,low,mid);
            ListNode h2=mergeSort(lists,mid+1,high);
            return merge(h1,h2);
        }
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode newHead = new ListNode(0);
        ListNode cur=newHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1 == null)
            cur.next=l2;
        else
            cur.next=l1;
        return newHead.next;
    }
}
