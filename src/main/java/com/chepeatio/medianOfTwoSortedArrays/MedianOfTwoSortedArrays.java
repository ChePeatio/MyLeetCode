package com.chepeatio.medianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/10.
 */
public class MedianOfTwoSortedArrays {
    /**
     * δʵ�ֵķ���
     * @param nums1 Ŀ������1
     * @param nums2 Ŀ������2
     * @return �����������λ��
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longer = nums1.length > nums2.length ? nums1 : nums2;
        int[] shorter = longer == nums1 ? nums2 : nums1;
        int m = longer.length;
        int n = shorter.length;
        if (n == 0) {
            return 0.0;
        }
        int min = 0, max = m, half_len = (m+n+1)/2;
        int max_of_left, min_of_right;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = half_len - i;
            if (j > 0 && i < m && shorter[j-1]>longer[i]) {
                min = i + 1;
            } else if (i > 0 && j < n && longer[i-1]>shorter[j]) {
                max = i - 1;
            } else {
                if (i == 0) {
                    max_of_left = shorter[j-1];
                } else if (j == 0) {
                    max_of_left = longer[i-1];
                } else {
                    max_of_left = Math.max(longer[i-1], shorter[j-1]);
                }

                if ((m + n) % 2 == 1) {
                    return max_of_left;
                }

                if (i == m) {
                    min_of_right = shorter[j];
                } else if (j == n) {
                    min_of_right = longer[i];
                } else {
                    min_of_right = Math.min(longer[i], shorter[j]);
                }
                return (max_of_left + min_of_right) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * ��ֱ�۵�ʵ�֣�ʱ��Ч�ʺܵ�
     * @param nums1 ����1
     * @param nums2 ����2
     * @return ���������������λ��
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
