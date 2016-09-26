package com.chepeatio.trappingRainWater;

import java.util.ArrayList;

/**
 * Created by Che Peatio on 2015/12/30.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1, low;
        while (left < right) {
            low = height[left] > height[right] ? height[right] : height[left];
            for (int i=left+1; i<right; i++) {
                if (height[i] < low) {
                    res += (low - height[i]);
                    height[i] = low;
                }
            }
            while (left<height.length && height[left] <= low) {
                left++;
            }
            while (right>=0 && height[right]<=low) {
                right--;
            }
        }
        return res;
    }
    public int trapTLE(int[] height) {
        int res = 0;
        int h = 1;
        int leftPos = 0, rightPos = 0;
        while (true) {
            int left = leftPos, right = rightPos;
            for (int i=leftPos; i<height.length; i++) {
                if (height[i] >= h) {
                    leftPos = i;
                    break;
                }
            }
            if (left == leftPos)
                break;
            for (int i=rightPos; i>=0; i--) {
                if (height[i] >= h) {
                    rightPos = i;
                    break;
                }
            }
            if (rightPos==right || rightPos==leftPos)
                break;
            for (int i=leftPos+1; i<rightPos; i++) {
                if (height[i]<h)
                    res++;
            }
            h++;
        }
        return res;
    }
}
