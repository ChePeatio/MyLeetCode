package com.chepeatio.h_Index;

/**
 * Created by Che Peatio on 2015/12/25.
 */
public class H_IndexII {

    /**
     * log(n) binary search solution
     * @param citations citations array is sorted in ascending order
     * @return h-index
     */
    public int hIndexFaster(int[] citations) {
        int l=0, r=citations.length-1, n=citations.length;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(n-mid<=citations[mid])
                r = mid-1;
            else
                l = mid+1;
        }
        return n - l;
    }

    /**
     * O(n) linear solution
     * @param citations citations array is sorted in ascending order
     * @return h-index
     */
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0)
            return 0;
        int len = citations.length;
        int res = citations[len-1] > len ? len : citations[len-1];
        if (res == 0)
            return 0;
        while (citations[len-res] < res) {
            res--;
        }
        return res;
    }
}
