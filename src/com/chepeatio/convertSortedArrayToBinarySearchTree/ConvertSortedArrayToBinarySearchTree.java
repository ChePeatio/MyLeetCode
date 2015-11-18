package com.chepeatio.convertSortedArrayToBinarySearchTree;

/**
 * Created by Che Peatio on 2015/11/18.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
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
}
