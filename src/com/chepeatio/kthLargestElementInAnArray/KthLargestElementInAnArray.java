package com.chepeatio.kthLargestElementInAnArray;

/**
 * Created by Che Peatio on 2016/1/7.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickselect(int[] nums, int k, int left, int end) {
        int mid = left;
        for (int i = mid; i < end; i++)// Take nums[end] as the pivot,
            if (nums[i] < nums[end])
                swap(nums, mid++, i);// Put numbers < pivot to pivot's left
        swap(nums, mid, end); // Finally, swap nums[end] with nums[mid] (mid is actually the index of the pivot nums[end])

        if (mid == k) return nums[mid];// Found kth smallest number
        else if (mid > k) return quickselect(nums, k, left, mid - 1);// Check left part
        else return quickselect(nums, k, mid + 1, end);// Check Right part
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
