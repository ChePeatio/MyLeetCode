package com.chepeatio.mergeSortedArray;

/**
 * Created by Che Peatio on 2016/1/13.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m-1;
        int pos2 = n-1;
        int i = m + n - 1;
        while (pos1>=0 && pos2>=0) {
            nums1[i--] = nums1[pos1] > nums2[pos2] ? nums1[pos1--] : nums2[pos2--];
        }
        while (pos2 >= 0) {
            nums1[i--] = nums2[pos2--];
        }
    }

    /**
     * This is my ugly code!!!
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeUglySolution(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }

        int pos1 = m-1, pos2 = n-1;
        for (int i=m+n-1; i>=0; i--) {
            if (nums1[pos1] > nums2[pos2]) {
                nums1[i] = nums1[pos1--];
                if (pos1 < 0) {
                    while (--i >=0) {
                        nums1[i] = nums2[pos2--];
                    }
                }
            } else {
                nums1[i] = nums2[pos2--];
                if (pos2 < 0)
                    return;
            }
        }
    }
}
