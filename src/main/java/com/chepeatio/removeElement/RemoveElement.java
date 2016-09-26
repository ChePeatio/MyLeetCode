package com.chepeatio.removeElement;

/**
 * Created by Che Peatio on 2015/12/19.
 */
public class RemoveElement {
    /**
     * No guarantee the sequence of list and the effectiveness is better than the first one
     * @param nums is list
     * @param val remove number
     * @return rest list length
     */
    public int removeElement(int[] nums, int val) {
        int first=0, last = nums.length-1;
        while (first <= last) {
            if (nums[first]!=val)
                first++;
            else {
                if (nums[last]!=val) {
                    nums[first] = nums[last];
                }
                last--;
            }
        }
        // The 'first' originally presents the index, while the last '++' operation make it be the length of list.
        return first;
    }

    /**
     * Guarantee the sequence of list and effectiveness is lower than no guaranteed algorithm
     * @param nums list
     * @param val remove number
     * @return rest list length
     */
    public int removeElement2ms(int[] nums, int val) {
        int replaceNum = 0;
        for (int i=0; i<nums.length; i++) {
            if (val == nums[i]) {
                replaceNum++;
            } else {
                nums[i - replaceNum] = nums[i];
            }
        }
        return nums.length-replaceNum;
    }
}
