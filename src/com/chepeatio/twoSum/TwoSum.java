package com.chepeatio.twoSum;

import java.util.Arrays;

/**
 * Created by Che Peatio on 2015/11/7.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] cpNums = nums.clone();
        Arrays.sort(cpNums);
        int maxPos = cpNums.length-1;

        for (int i=0; i<cpNums.length; i++) {
            for (int j=maxPos; j>i; j--) {
                if (cpNums[i] + cpNums[j] < target)
                    break;
                else if (cpNums[i] + cpNums[j] == target) {
                    int pos = 0;
                    for (int k=0; k<nums.length; k++) {
                        if (cpNums[i]==nums[k] || cpNums[j]==nums[k]) {
                            result[pos++] = k+1;
                            if (pos == 2)
                                return result;
                        }
                    }
                } else {
                    maxPos = j;
                }
            }
        }
        return result;
    }

    public int[] twoSumBS(int[] nums, int target) {
        int[] OriNum=nums.clone();
        Arrays.sort(OriNum);
        int left=0,right=OriNum.length-1;
        while(left<right){
            if (OriNum[left]+OriNum[right]>target) {
                right--;
            } else if (OriNum[left]+OriNum[right]<target) {
                left++;
            } else {
                int[] rs=new int[2];
                int pos=0;
                for(int i=0;i<nums.length;i++){
                    if(nums[i]==OriNum[left]||nums[i]==OriNum[right]) {
                        rs[pos++] = i + 1;
                        if (pos == 2)
                            return rs;
                    }
                }
            }
        }
        return new int[]{1,2};
    }
}
