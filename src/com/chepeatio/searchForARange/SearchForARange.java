package com.chepeatio.searchForARange;

/**
 * Created by Che Peatio on 2016/5/8.
 */
public class SearchForARange {
    /**
     * ͨ�����ֲ���ÿ��target����С�±�ֵ���ж�target�Ƿ���ڣ�
     * ������ڣ���������target+1��λ�ã����жϸ�λ���Ƿ����target��target�����������ֵ�������
     * ���ֲ��ҵ�Ч����O(logn)���������ط����������㷨�ĸ��Ӷȣ������㷨ʱ�临�Ӷ�ΪO(logn)����������
     * @param nums ��������
     * @param target Ŀ��ֵ
     * @return �±귶Χ
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = getIndex(nums, target);
        if (nums[res[0]] != target) {
            res[0] = -1;
            res[1] = -1;
        } else {
            res[1] = getIndex(nums, target+1);
            if (nums[res[1]] > target)
                res[1]--;
        }
        return res;
    }

    /**
     * �ö��ֲ��ҷ����ҵ�targetֵ����Сindex
     * @param nums �����������
     * @param target ����ֵ
     * @return ��Сindex
     */
    private int getIndex(int[] nums, int target) {
        int left = 0, right = nums.length-1, medium;
        while (left < right) {
            medium = (left + right) >> 1;
            if (nums[medium] < target) {
                left = medium + 1;
            } else if (nums[medium] == target) {
                if (medium==0 || nums[medium-1]<target)
                    return medium;
                else
                    right = medium - 1;
            } else {
                right = medium;
            }
        }
        return left;
    }
}
