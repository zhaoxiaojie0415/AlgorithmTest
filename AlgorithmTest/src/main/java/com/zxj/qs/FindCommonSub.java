package com.zxj.qs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qs on 2018/3/26.
 */
public class FindCommonSub {
    public void solution(String[] s1, String[] s2) {
        List<String> resultList = new ArrayList<String>();
        int l1 = s1.length;
        int l2 = s2.length;
        List<String> common = findCommon(s1, s2, l1, l2);
        System.out.println(common);
    }

    private List<String> findCommon(String[] s1, String[] s2, int s1r, int s2r) {
        System.out.println("s1:" + s1r + ", s2:" + s2r);
        if (s2r < s1r) {
            return findCommon(s2, s1, s2r, s1r);
        }
        List<String> resultList = new ArrayList<String>();
        if (s1r == 0) {
            for (int i =0; i < s2r; i++) {
                if (s2[i].equals(s1[s1r]) ) {
                    resultList.add(s1[s1r]);
                }
            }
            return resultList;
        }
        if (s1[s1r-1].equals(s2[s2r-1])) {
            List<String> lastresult = findCommon(s1, s2, s1r - 1, s2r - 1);
            lastresult.add(s1[s1r-1]);
            return lastresult;
        } else {
            List<String> lastresult1 = findCommon(s1, s2, s1r - 1, s2r);
            List<String> lastresult2 = findCommon(s1, s2, s1r , s2r-1);
            if (lastresult1.size() > lastresult2.size()) {
                return lastresult1;
            } else {
                return lastresult2;
            }
        }
    }

    public void solution2(String[] s1, String[] s2) {
        int l1 = s1.length;
        int l2 = s2.length;
        boolean[][] res = new boolean[l1][l2];

    }


    public static void main(String[] args) {
        FindCommonSub sub = new FindCommonSub();
        String[] s1 = new String[]{"a", "d", "e" ,"c", "f"};
        String[] s2 = new String[]{"e", "f", "a" ,"c", "f", "e"};
        sub.solution(s1, s2);
    }
}
