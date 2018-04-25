package com.zxj.qs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qs on 2018/3/26.
 */
public class LISSolution {

    public void findLIS(int [] inputs) {
        int n = inputs.length;
        List<Integer> result = new ArrayList<Integer>();
        findMax(inputs, n-1, result);
        System.out.println(result);

    }
    public void findMax(int []inputs, int end, List<Integer> result) {
        if (end == 0) {
            result.add(inputs[end]);
            return;
        }
        findMax(inputs, end - 1, result);
        if (result.get(result.size() - 1) < inputs[end]) {
            result.add(inputs[end]);
        } else {
//            findMax(inputs, end - 1, result);
        }
    }

    public static void main(String[] args) {
        LISSolution so = new LISSolution();
        so.findLIS(new int[]{3,7,5,8,6,9});
    }
}
