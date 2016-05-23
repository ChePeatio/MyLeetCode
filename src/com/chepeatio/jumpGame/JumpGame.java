package com.chepeatio.jumpGame;

/**
 * Created by Che Peatio on 2016/5/23.
 */
public class JumpGame {

    /**
     * This version used a flag number to record how long we can jump, and it's fast and easy to understand.
     * @param nums integer array
     * @return boolean
     */
    public boolean canJumpFlag(int[] nums) {
        int flag = nums[0], targetPos = nums.length-1, i=0, val;
        while (i <= flag) {
            val = i + nums[i];
            flag = val > flag ? val : flag;
            if (flag >= targetPos)
                break;
            i++;
        }

        return flag >= targetPos;
    }

    /**
     * This version used an array to record weather can jump to the position,
     * and back search can jump to reduce the time. However, it's a bad solution for using the extra space.
     * @param nums integer array
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        int targetPos = nums.length - 1, reached;
        for (int i=0; i<targetPos && canReach[i]; i++) {
            if (canReach[i]) {
                for (int j=nums[i]; j>0; j--) {
                    reached = i + j;
                    if (reached >= targetPos)
                        return true;
                    if (canReach[reached])
                        break;
                    canReach[reached] = true;
                }
            }
        }
        return canReach[nums.length-1];
    }
}
