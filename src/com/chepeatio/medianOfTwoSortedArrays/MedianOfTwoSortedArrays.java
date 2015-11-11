package com.chepeatio.medianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/10.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> totalNums = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if (m + n == 0)
            return 0;
        int i1 = 0, i2 = 0;
        while (i1 < m && i2 < n) {
            if (nums1[i1] < nums2[i2]) {
                totalNums.add(nums1[i1++]);
            } else if (nums1[i1] > nums2[i2]) {
                totalNums.add(nums2[i2++]);
            } else {
                totalNums.add(nums1[i1++]);
                totalNums.add(nums2[i2++]);
            }
        }
        while (i1 < m) {
            totalNums.add(nums1[i1++]);
        }
        while (i2 < n) {
            totalNums.add(nums2[i2++]);
        }
        int size = m + n;
        if (size % 2 == 1) {
            return totalNums.get(size / 2) * 1.0;
        } else {
            return (totalNums.get(size / 2) + totalNums.get(size / 2 - 1)) * 1.0 / 2;
        }
    }
}
