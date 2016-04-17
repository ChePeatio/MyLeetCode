package com.chepeatio.stringToInteger;

/**
 * Created by Che Peatio on 2016/4/16.
 */
public class StringToInteger {

    /**
     * �ο� Java IntegerԴ����ɵģ�Դ��д��ȷʵƯ����Ӧ�ö�ѧϰ��
     * �������ж�����ĵط������ڸ����ĸ����������������ȫ��ʹ�ø����жϣ���˲���Ҫ�ֿ����ۡ�
     * @param str string to be translated into integer.
     * @return integer of the string.
     */
    public int myAtoi(String str) {

        if (str == null) // �ַ���Ϊnull���쳣���
            return 0;

        int result = 0; // ���ؽ��
        boolean negative = false; // �Ƿ�Ϊ����
        int len = str.length(); // �ַ������ȣ������õ��������õĵط�������ǰ�ñ�����ã�Ϊ�˸��õ�Ч��
        int limit = -Integer.MAX_VALUE; // �������ǰ���µļ���ֵ����ǰ�������ļ���ֵ��ͳһ�ø�����ʾ����Χ����
        int multmin; // ���˷�����ǰ������ļ���ֵ����limit�йأ�����˵������йأ�
        int digit; // ��ǰλ��ֵ
        int index = 0; // string���±�

        if (len > 0) {

            // remove empty space in the string.
            while (str.charAt(index) == ' ' && index < len) {
                index++;
            }
            if (index >= len) // ȫ�ǿո��ַ����쳣���
                return 0;

            char firstChar = str.charAt(index);
            // �жϵ�һ���ַ��Ƿ�Ϊ���ţ������ݷ��ŵ���limitֵ
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') { // �������ַ����쳣���
                    return 0;
                }
                if (index == len-1) { // ֻ��+/-��û�����ֵ��쳣���
                    return 0;
                }
                index++;
            }

            // ����integerֵ��������������쳣
            multmin = limit / 10;
            while (index < len) {
                digit = Character.digit(str.charAt(index++), 10);
                if (digit < 0) { // �ַ������������е�ֵ����
                    break;
                }

                if (result < multmin) { // �����ڸ�����Χ�ڼ��㣬���result<multmin����result*10�϶������
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) { // �����ڸ�����Χ�ڼ��㣬���result-digit<limit��˵�������
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0; // �ַ�����Ϊ0���쳣���
        }
        return negative ? result : -result;
    }
}
