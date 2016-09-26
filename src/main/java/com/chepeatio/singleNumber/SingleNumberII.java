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
     * 位操作肯定是效率最高的，但是为了使用位操作而逐位的操作是没有低效的
     * 该解法是一种通用的解法，既然除一个数字之外其它数字都出现三次，那么每个bit也会出现三次，
     * 那么用状态00,01,10来表示三个状态（出现1次、2次、3次）并循环，即可达到过滤出现3次的情况，
     * 留下的bit组成的整数便是要求的数字
     * 对于状态转移，我使用了卡诺图来化简，从而使运行时间从2ms变为1ms。
     * @param nums 目标数组
     * @return 最终结果
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
