package com.chepeatio.moveZeros;

/**
 * Created by Che Peatio on 2015/10/25.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {

        if (nums.length == 0)
            return;

        int j;
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] == 0) {
                for(j=i; j<nums.length-1; j++) {
                    if (nums[j+1] != 0) {
                        nums[j] = nums[j+1];
                    } else {
                        nums[j] = 0;
                        break;
                    }
                }
                if (j==nums.length-1) {
                    nums[j] = 0;
                }
            }
        }
    }

    public void moveZeroesBS(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            } else {
                nums[i-count] = nums[i];
            }
        }
        for (int i=0; i<count; i++) {
            nums[nums.length-count+i] = 0;
        }
    }
}
