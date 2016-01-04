package com.chepeatio.burstBalloons;

/**
 * Created by Che Peatio on 2016/1/2.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        // Generate a linked list to store the nums.
        int count = 0;
        LinkedNode head = new LinkedNode(1);
        LinkedNode tail = new LinkedNode(1);
        LinkedNode temp = head, temp2;
        for (int num : nums) {
            if (num != 0) { // filter 0 for further process
                temp2 = new LinkedNode(num);
                temp.right = temp2;
                temp2.left = temp;
                temp = temp2;
                count++;
            }
        }
        temp.right = tail;
        tail.left = temp;

        // handle 1 in two sides
        int countOf1 = 0;
        while (head.right.val == 1) {
            if (head.right == tail) {
                return countOf1;
            } else {
                head = head.right;
                countOf1++;
            }
        }
        while (tail.left.val == 1) {
            tail = tail.left;
            countOf1++;
        }
        count -= countOf1;

        // data will be head-(x1>1)-...-(xn>1)-tail
        temp = head.right;
        int res = 1;
        while (head.right.right != tail) {
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
        res += temp.val * (countOf1 + 1);
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
