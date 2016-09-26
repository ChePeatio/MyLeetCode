package com.chepeatio.containerWithMostWater;

import com.chepeatio.Main;

/**
 * Created by Che Peatio on 2015/12/8.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int res = 0;
        int first=0, last = height.length-1, area, width;
        while (first < last) {
            width = height[first] > height[last] ? height[last] : height[first];
            area = (last - first) * width;
            res = area > res ? area : res;

            if (height[first] > height[last]) {
                last--;
            } else {
                first++;
            }
        }
        return res;
    }

    public int maxAreaTLE(int[] height) {
        int res = 0;
        int width, area, maxWidth, lastMaxWidth = 0;
        for (int length=height.length-1; length>0; length--) {
            maxWidth = 0;
            int range = height.length - length;
            for (int i=0; i<range; i++) {
                int bound = i + length;
                width = height[i] > height[bound] ? height[bound] : height[i];
                maxWidth = width > maxWidth ? width : maxWidth;
            }
            if (lastMaxWidth < maxWidth) {
                area = maxWidth * length;
                res = res < area ? area : res;
                lastMaxWidth = maxWidth;
            }
        }
        return res;
    }
}
