package com.chepeatio.h_Index;

import java.util.*;

/**
 * Created by Che Peatio on 2015/12/25.
 */
public class H_Index {

    /**
     * O(n) solution without sort.
     * Using 'arr' as a map, and the citation if bigger than length, the h-index will be length,
     * so we only need a more space to store the count of the bigger citations.
     * @param citations citations array is sorted in ascending order
     * @return h-index
     */
    public int hIndex(int[] citations) {
        int n = citations.length, tot=0;
        int[] arr = new int[n+1];
        for (int citation : citations) {
            if (citation >= n)
                arr[n]++;
            else
                arr[citation]++;
        }
        for (int i=n; i>=0; i--) {
            tot += arr[i];
            if (tot>=i) return i;
        }
        return 0;
    }

    /**
     * Sort the array and using binary search
     * @param citations citations array is sorted in ascending order
     * @return h-index
     */
    public int hIndexEasySolution(int[] citations) {
        Arrays.sort(citations);
        return hIndexFaster(citations);
    }

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
}
