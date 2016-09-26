package com.chepeatio.findTheDuplicateNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/11/16.
 */
public class FindTheDuplicateNumber {

    /**
     * ʹ���˸�������ѭ������㷨��������֪����ʲô��
     * @param nums Ŀ������
     * @return �ظ���ֵ
     */
    public int findDuplicateBS(int[] nums) {
        int slow = 0;
        int fast = 0;
        int finder = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != finder)
        {
            slow = nums[slow];
            finder = nums[finder];
        }
        return slow;
    }

    /**
     * ���ֲ��ҵķ�������ʱ�临�Ӷȴ�n^2����nlogn����һ���̶������Ч��
     * @param nums Ŀ������
     * @return �ظ�������
     */
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int medium;
        while (low <= high) {
            medium = (int)(low + (high - low) * 0.5);
            int count = 0;
            for (int num : nums) {
                if (num <= medium)
                    count++;
            }
            if (count <= medium)
                low = medium + 1;
            else
                high = medium - 1;
        }
        return low;
    }

    public int findDuplicateNS(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
