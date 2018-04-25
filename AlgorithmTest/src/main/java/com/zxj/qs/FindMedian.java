package com.zxj.qs;

/**
 * Created by qs on 2018/3/21.
 */
public class FindMedian {
    public static void main(String[] args) {

    }

    public static double finMedianForTwoSorts( int[] a1, int[] a2) {
        int m = a1.length;
        int n = a2.length;
        if (m ==0 || n ==0) {

        }
        int k = (m + n) /2;
        if (((m+n) % 2) == 0) {
            return (findKth(a1, 0, m, a2, 0 , n, k) + findKth(a1, 0, m, a2, 0 , n, k +1)) /2;
        } else {
            return findKth(a1, 0, m, a2, 0 , n, k + 1);
        }
    }

    private static double findKth(int[] a1, int start1, int len1, int[] a2, int start2, int len2, int k) {
        if (len1 > len2) {
            findKth(a2, start2, len2, a1, start1, len1, k);
        }
        if (len1 ==0) {
            return a2[start2 + k-1];
        }
        if (k ==1) {
            return Math.min(a1[start1], a2[start2]);
        }

        int p = Math.min(len1, k/2);
        int q = k - p;
        if (a1[start1 + p-1] > a2[start2 + q -1]) {
            return findKth(a1, start1, p, a2, q, len2 -q,k-q );
        } else if (a1[start1 + p-1] < a2[start2 + q -1]) {
            return findKth(a1, p, len1-p, a2, start2, len2 -q,k-p );
        } else {
            return a1[start1 + p-1];
        }



    }
}
