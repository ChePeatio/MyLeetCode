package com.chepeatio.countAndSay;

/**
 * Created by Che Peatio on 2016/5/3.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        if (n <= 1)
            return s;
        int count = 0;
        char cur;
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<n; i++) {

            cur = chs[0];
            count = 1;
            for (int j=1; j<chs.length; j++) {
                if (cur == chs[j])
                    count++;
                else {
                    sb.append(count);
                    sb.append(cur);
                    cur = chs[j];
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(cur);

            chs = sb.toString().toCharArray();
            sb.delete(0, chs.length);
        }
        return String.valueOf(chs);
    }
}
