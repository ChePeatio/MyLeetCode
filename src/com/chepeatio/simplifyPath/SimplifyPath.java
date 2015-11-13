package com.chepeatio.simplifyPath;

/**
 * Created by Che Peatio on 2015/11/13.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] token = path.split("/");
        String[] temp = new String[token.length];
        int pos = 0;
        for (String s : token) {
            if (s.length()==0 || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (pos != 0)
                    pos--;
            } else {
                temp[pos++] = s;
            }
        }
        for (int i=0; i<pos; i++) {
            res.append("/");
            res.append(temp[i]);
        }
        if (pos == 0)
            res.append("/");
        return res.toString();
    }
}
