package com.chepeatio.kthLargestElementInAnArray;

/**
 * Created by Che Peatio on 2016/1/7.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        for(int i=nums.length/2; i>0; i--)
            maxHeapify(nums, i, nums.length);

        for(int i=1; i<k; i++) {
            int tmp = nums[nums.length-i];
            nums[nums.length-i] = nums[0];
            nums[0] = tmp;

            maxHeapify(nums, 1, nums.length-i);
        }
        return nums[0];
    }

    void maxHeapify(int[] nums, int index, int size) {
        int left = index<<1, right = (index<<1)+1;
        int max = index;

        if(left<=size && nums[left-1]>nums[max-1]) max = left;
        if(right<=size && nums[right-1]>nums[max-1]) max = right;
        if(max!= index) {
            int tmp = nums[max-1];
            nums[max-1] = nums[index-1];
            nums[index-1] = tmp;

            maxHeapify(nums, max, size);
        }
    }

    /**
     * Quick select solution! Binary divide solution is very good, but bad efficient.
     * @param nums list
     * @param k target
     * @return value
     */
    public int findKthLargestBES(int[] nums, int k) {
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
