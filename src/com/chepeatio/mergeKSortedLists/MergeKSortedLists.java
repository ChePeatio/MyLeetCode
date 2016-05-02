package com.chepeatio.mergeKSortedLists;

import com.chepeatio.utils.ListNode;

import java.util.PriorityQueue;

/**
 * Created by Che Peatio on 2016/5/1.
 */
public class MergeKSortedLists {

    /**
     * 使用java提供的heap来实现TLE版本的想法，代码简短了很多，可学性很高，
     * 但该数据结构通用性强，效率比较差，所以AC的时间很长
     * @param lists 待处理的队列
     * @return 融合的队列
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
     * 同TLE版本的思想，使用堆降低了数据排序的复杂度，将O(n*k)的算法改为了O(nlogk)的算法，其中n是元素个数，k是队列个数
     * 堆排序的实现也是很easy的嘛
     * @param lists 待处理的队列
     * @return 融合的队列
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
     * TLE version，总体想法是利用一个数组记录当前lists头部的排序信息，
     * 每次并入最小的node，再次更新数组。
     * 但排序+更新使用的是遍历的方式，效率太低。
     * @param lists 待处理的队列
     * @return 完整的队列
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
     * 分治算法，时间复杂度相近，也是O(nlogk)
     * @param lists 待处理的队列
     * @return 融合的队列
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
