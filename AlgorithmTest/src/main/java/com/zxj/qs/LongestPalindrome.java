package com.zxj.qs;

/**
 * Created by qs on 2018/3/26.
 */
public class LongestPalindrome {

    public void findLong(String[] s) {
        int length = s.length;
        if (length ==1) {
            System.out.println(s);
        }if (length ==0) {
            System.out.println(-1);
        }
        int maxlength = 0;
        int maxstart = 0;
        boolean[][] res = new boolean[length][length];
        for (int i =0; i < length; i++) {
            for (int j =0; j <length -i; j++) {
                if (i ==0 ||i ==1) {
                    res[j][j+i] = true;
                } else if (s[j] == s[i+j]) {
                    res[j][j+i] = res[j+1][j+i-1];
                } else {
                    res[j][j+i] = false;
                }
                if (res[j][j+i] && i > maxlength) {
                    maxlength = i+1;
                    maxstart = j;
                }
            }
        }

    }
    public void find2(String[] s) {
        for (int i =0; i < s.length; i ++) {
            helper(s, i, 0);
            helper(s, i, 1);
        }
    }

    private void helper(String[] s, int i, int offset) {
        int left = i;
        int right = i + offset;
        while(left >=0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        String currentlongest = s.toString().substring(left + 1, right);

    }
}
