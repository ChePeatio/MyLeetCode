package com.chepeatio.medianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/10.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length == 0)
                return 0;
            else if (nums2.length % 2 == 1)
                return nums2[nums2.length/2] * 1.0;
            else
                return (nums2[nums2.length/2] + nums2[nums2.length/2-1]) * 1.0 / 2;
        } else {
            if (nums2.length == 0) {
                if (nums1.length % 2 == 1)
                    return nums1[nums1.length/2] * 1.0;
                else
                    return (nums1[nums1.length/2] + nums1[nums1.length/2-1]) * 1.0 / 2;
            } else {
                int left1 = 0, right1 = nums1.length-1, left2 = 0, right2 = nums2.length-1;
                int medium1 = (left1+right1) / 2, medium2 = (left2+right2) / 2;
                while (left1!= medium1 && left2!=medium2) {
                    medium1 = (left1 + right1) / 2;
                }

                return 0.0;
            }
        }
    }

    /**
     * 最直观的实现，时空效率很低
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 两个数组总体的中位数
     */
    public double findMedianSortedArraysLS(int[] nums1, int[] nums2) {
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
