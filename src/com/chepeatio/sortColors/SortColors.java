package com.chepeatio.sortColors;

/**
 * Created by Che Peatio on 2015/11/23.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        for (int num : nums) {
            if (num == 0) red++;
            else if (num == 1) white++;
            else blue++;
        }
        for (int i=0; i<red; i++) {
            nums[i] = 0;
        }
        int len = white+red;
        for (int i=red; i<len; i++) {
            nums[i] = 1;
        }
        for (int i=len; i<nums.length; i++) {
            nums[i] = 2;
        }
    }
}
