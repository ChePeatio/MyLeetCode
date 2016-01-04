package com.chepeatio.burstBalloons;

/**
 * Created by Che Peatio on 2016/1/2.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        // Judge if there is 0 in the list or the length of the array is 0.
        for (int num : nums) {
            if (num==0)
                return 0;
        }
        int count = nums.length;
        if (count == 0)
            return 0;

        // Generate a linked list to store the nums.
        LinkedNode head = new LinkedNode(1);
        LinkedNode tail = new LinkedNode(1);
        LinkedNode temp = head, temp2;
        for (int num : nums) {
            temp2 = new LinkedNode(num);
            temp.right = temp2;
            temp2.left = temp;
            temp = temp2;
        }
        temp.right = tail;
        tail.left = temp;

        temp = head.right;
        while (temp != null) {
            if (temp.val != 1) break;
            temp = temp.right;
        }
        if (temp == null)
            return count;

        int res = 1;
        while (temp.left!=head || temp.right!=tail) {
            if (temp.right.val > temp.val) {
                if (temp.left.val == -1) {
                    res += temp.val * temp.right.val;
                    temp.right.left = temp.left;
                    temp.left.right = temp.right;
                    temp = temp.right;
                } else {
                    res += temp.left.val * temp.val * temp.right.val;
                    temp.right.left = temp.left;
                    temp.left.right = temp.right;
                    temp = temp.left;
                }
            } else if (temp.right.val == temp.val) {
                if (temp.left.val == temp.val) {
                    res += temp.left.val * temp.val * temp.right.val;
                    temp.right.left = temp.left;
                    temp.left.right = temp.right;
                    temp = temp.left;
                } // there should be more handle process
            } else if (temp.right.val == -1) {
                if (temp.left.val > temp.val) {

                }
                temp = head.right;
            } else {
                temp = temp.right;
            }
        }
        res += temp.val;
        return res;
    }

    class LinkedNode {
        LinkedNode left;
        LinkedNode right;
        int val;

        public LinkedNode(int num) {
            val = num;
        }
    }
}
