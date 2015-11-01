package com.chepeatio.productOfArrayExceptSelf;

/**
 * Created by Che Peatio on 2015/11/1.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int posZero = -1;
        int product = 1;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                if (posZero != -1) {
                    posZero = -2;
                    break;
                } else {
                    posZero = i;
                }
            } else {
                product *= nums[i];
            }
        }

        if (posZero == -1) {
            for (int i=0; i<nums.length; i++) {
                result[i] = product / nums[i];
            }
        } else if (posZero != -2) {
            result[posZero] = product;
        }
        return result;
    }

    public int[] productExceptSelfAS(int[] nums) {
        int[] result = new int[nums.length];
        int leftProd = 1;
        result[nums.length-1] = 1;
        for(int i = nums.length-2;i>=0;i--)
            result[i] = result[i+1]*nums[i+1];
        leftProd = leftProd*nums[0];
        for(int i=1;i<=nums.length-1;i++){
            result[i] = result[i]*leftProd;
            leftProd = leftProd*nums[i];
        }
        return result;
    }
}
