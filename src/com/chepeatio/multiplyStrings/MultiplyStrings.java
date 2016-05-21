package com.chepeatio.multiplyStrings;

/**
 * Created by Che Peatio on 2016/5/21.
 */
public class MultiplyStrings {

    /**
     * 本解法也是乘法原理，但在更新数据时使用了技巧，即num1[i]*num2[j] will be placed at indices res[i+j, i+j+1]
     * 当然我也做了另一方面的修改(基于当前值不会超过integer的情况)，即不需要每次都更新pos，
     * 而是最后统一更新整个pos,从而提高效率,目前时间是前一个的一半左右。
     * @param num1 String of non-negative number1
     * @param num2 String of non-negative number2
     * @return result
     */
    public String multiplyFaster(String num1, String num2) {
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        if (chs1.length==0 || chs2.length==0)
            return "";
        char[] lc = chs1.length < chs2.length ? chs2 : chs1;
        char[] sc = chs1.length < chs2.length ? chs1 : chs2;
        int mul;
        int[] resArray = new int[lc.length + sc.length];

        for(int i = sc.length - 1; i >= 0; i--) {
            for(int j = lc.length - 1; j >= 0; j--) {
                mul = (sc[i] - '0') * (lc[j] - '0');
                int p = i + j + 1;
                resArray[p] = resArray[p] + mul;
            }
        }

        for (int i=resArray.length-1; i>0; i--) {
            if (resArray[i] > 9) {
                resArray[i-1] += resArray[i] / 10;
                resArray[i] = resArray[i] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i<resArray.length && resArray[i] == 0)
            i++;
        for (; i<resArray.length; i++) {
            sb.append(resArray[i]);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

    /**
     * 使用基本的乘法原理计算，用较短的字串的每个数依次乘以较长字符串，将得到的结果合并整理
     * 从而得到最终结果，记两个字符串长度分别为m和n，则时间效率应该是O(n*m)，实际效率比较低。
     * @param num1 String of non-negative number1
     * @param num2 String of non-negative number2
     * @return multiply result
     */
    public String multiply(String num1, String num2) {
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        if (chs1.length==0 || chs2.length==0)
            return "";
        char[] lc = chs1.length < chs2.length ? chs2 : chs1;
        char[] sc = chs1.length < chs2.length ? chs1 : chs2;
        int i, j, k, temp;

        int[] resArray = new int[lc.length+sc.length];

        for (i=sc.length-1; i>=0; i--) {
            int[] v = new int[lc.length+sc.length-i];
            k = lc.length;
            for (j=lc.length-1; j>=0; j--) {
                temp = (lc[j]-'0') * (sc[i]-'0') + v[k];
                v[k] = temp % 10;
                v[--k] = temp / 10;
            }
            arrayPlusArray(resArray, v);
        }

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i<resArray.length && resArray[i] == 0)
            i++;
        for (; i<resArray.length; i++) {
            sb.append(resArray[i]);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

    private void arrayPlusArray(int[] array1, int[] array2) {
        int val = 0;
        for (int i=1; i<=array2.length; i++) {
            val = array1[array1.length-i] + array2[array2.length-i];
            if (val > 9) {
                array1[array1.length - i] = val % 10;
                array1[array1.length - i - 1] += val / 10;
            } else {
                array1[array1.length - i] = val;
            }
        }
        for (int i=array2.length+1; i<array1.length; i++) {
            if (array1[array1.length-i] > 9) {
                array1[array1.length-i] = 0;
                array1[array1.length-i-1] += 1;
            }
        }
    }
}
