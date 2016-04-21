package com.chepeatio.nextPermutation;

/**
 * Created by Che Peatio on 2016/4/18.
 * Edited by Che Peatio on 2016/4/21.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length<2)
            return;
        int pos = nums.length - 1;
        for (; pos>0; pos--) {
            if (nums[pos] > nums[pos-1]) {
                break;
            }
        }
        pos--;
        if (pos >= 0) {
            int index = nums.length - 1;
            while (index > pos) {
                if (nums[index] > nums[pos]) {
                    swap(nums, pos, index);
                    break;
                }
                index--;
            }
        }
        reverseSort(nums, pos+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseSort(int[] nums, int start) {
        if (start >= nums.length-1)
            return;
        int len = (start+nums.length)/2;
        int temp;
        for (int i=start; i<len; i++) {
            int other = start+nums.length-1-i;
            swap(nums, i, other);
        }
    }
}
