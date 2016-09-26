package com.chepeatio.singleNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/11/12.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Set<Integer> badSet = new HashSet<>();
        Set<Integer> goodSet = new HashSet<>();
        for (int num : nums) {
            if (badSet.contains(num)) {
            } else if (goodSet.contains(num)) {
                goodSet.remove(num);
                badSet.add(num);
            } else {
                goodSet.add(num);
            }
        }
        Object[] obj = goodSet.toArray();
        return (int)obj[0];
    }

    /**
     * λ�����϶���Ч����ߵģ�����Ϊ��ʹ��λ��������λ�Ĳ�����û�е�Ч��
     * �ýⷨ��һ��ͨ�õĽⷨ����Ȼ��һ������֮���������ֶ��������Σ���ôÿ��bitҲ��������Σ�
     * ��ô��״̬00,01,10����ʾ����״̬������1�Ρ�2�Ρ�3�Σ���ѭ�������ɴﵽ���˳���3�ε������
     * ���µ�bit��ɵ���������Ҫ�������
     * ����״̬ת�ƣ���ʹ���˿�ŵͼ�����򣬴Ӷ�ʹ����ʱ���2ms��Ϊ1ms��
     * @param nums Ŀ������
     * @return ���ս��
     */
    public int singleNumberBS(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int ta = a&~num | b&num;
            b = b&~num | ~a&~b&num;
            a = ta;
        }

        return b;
    }
}
