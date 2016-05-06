package com.chepeatio.longestValidParentheses;


/**
 * Created by Che Peatio on 2016/5/4.
 * Edited by Che Peatio on 2016/5/6.
 */
public class LongestValidParentheses {

    /**
     * ��һ��������ŵ�Hard��Ŀ��ʹ��ջ��stack����¼��ǰ��ƥ��������ţ���valid��pos��¼ƥ��ĸ�����λ�ã�
     * ������λ��ȷ����ǰ��������Ƿ����ӣ�������ϲ������򲻺ϲ�������stack���׵����������-1��������ǰ�����ϵ
     * ʱ��Ч��Ҳ����
     * @param s ��ƥ��������ַ���
     * @return ���ƥ����ַ���
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        char[] chs = s.toCharArray();
        int stack = 0;
        int[] valid = new int[chs.length];
        int[] pos = new int[chs.length];
        int index = 0;

        for (char ch : chs) {
            if (ch == '(') {
                stack++;
            } else if (stack <= 0){
                stack = 0;
                valid[index] = -1;
                pos[index] = -1;
                index++;
            } else {
                stack--;
                valid[index] = 2;
                pos[index] = stack;

                while (index>0 && pos[index-1]>=stack) {
                    valid[index-1] += valid[index];
                    pos[index-1] = pos[index];
                    index--;
                }
                index++;
            }
        }

        for (int i=0; i<index; i++) {
            res = res < valid[i] ? valid[i] : res;
        }

        return res;
    }
}
