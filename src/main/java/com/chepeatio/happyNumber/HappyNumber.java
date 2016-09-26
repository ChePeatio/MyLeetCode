package com.chepeatio.happyNumber;

/**
 * Created by Che Peatio on 2015/11/12.
 */
public class HappyNumber {

    /**
     * �����ֱ�۵��㷨������Set����¼���Happy Numberʱ�Ƿ����ѭ��
     * ��Unhappy Number�������4/16/�������ѭ�������ÿ�μ���Ľ���ж�����Щ���Ƿ�һ������
     * @param n Ŀ������
     * @return �Ƿ���happy number
     */
    public boolean isHappy(int n) {
        int sum = n;
        int temp;
        while (sum != 1) {
            temp = sum;
            sum = 0;
            while (temp != 0) {
                sum += (temp%10) * (temp%10);
                temp /= 10;
            }
            if (sum==4 || sum==16 || sum == 37 || sum == 42 || sum == 58 || sum == 89 || sum == 145)
                return false;
        }

        return true;
    }
}
