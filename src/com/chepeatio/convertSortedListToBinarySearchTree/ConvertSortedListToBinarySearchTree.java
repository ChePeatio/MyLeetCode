package com.chepeatio.convertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/15.
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * This solution is O(nlog(n)), but it much faster than my solution, while my solution should be O(n).
     * Fast and slow points are good flag to get the medium list node.
     * @param head list head
     * @return root of the tree
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // find the median node in the linked list, after executing this loop
        // fast will pointing to the last node, while slow is the median node.
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) prev.next = null;
        else head = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    /**
     * The time complexity of the solution is O(n), and the space complexity of the solution is O(log(n)).
     * This solution should be the best solution.
     *
     */
    ListNode list;
    public TreeNode sortedListToBSTAnotherSolution(ListNode head) {
        list = head;
        return generate(count(head));
    }

    private TreeNode generate(int n){
        if (n == 0)
            return null;
        TreeNode node = new TreeNode(0);
        node.left = generate(n / 2);
        node.val = list.val;
        list = list.next;
        node.right = generate(n - n / 2 - 1);
        return node;
    }

    private int count(ListNode node){
        int size = 0;
        while (node != null) {
            ++size;
            node = node.next;
        }
        return size;
    }

    /**
     *
     * @param head list head node
     * @return root of the tree
     */
    public TreeNode sortedListToBSTSlowSolution(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int[] nums = new int[list.size()];
        for (int i=0; i<nums.length; i++)
            nums[i] = list.get(i);

        return sortedArrayToBST(nums);
    }

    private TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int medium = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[medium]);
        int[] leftNums = new int[medium];
        System.arraycopy(nums, 0, leftNums, 0, leftNums.length);
        int[] rightNums = new int[nums.length-medium-1];
        for (int i=0; i<rightNums.length; i++) {
            rightNums[i] = nums[i+medium+1];
        }
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }

    public ListNode getListHead() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        return head;
    }

    public void displayTree(TreeNode root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(root.val + " ");
            displayTree(root.right);
        }
    }
}
