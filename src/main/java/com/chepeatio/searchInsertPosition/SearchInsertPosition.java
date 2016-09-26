package com.chepeatio.searchInsertPosition;

/**
 * Created by Che Peatio on 2015/11/10.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums==null || nums.length==0)
            return 0;

        int left = 0, right = nums.length-1, medium;
        while (left < right) {
            medium = (left + right) / 2;
            if (nums[medium] > target) {
                right = medium-1;
            } else if (nums[medium] < target) {
                left = medium+1;
            } else{
                return medium;
            }
        }
        if (nums[left] > target) {
            return left;
        } else if (nums[right] < target){
            return right+1;
        } else {
            return left;
        }
    }
}
