package com.zxj.qs;

import java.util.Scanner;

/**
 * Created by qs on 2018/3/21.
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入总数量 n");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i< n; i++) {
            array[i] = sc.nextInt();
        }
        quicksort(array, 0, n-1);
        for (int j=0; j<n; j++) {
            System.out.println(array[j]);
        }
    }

    private static void quicksort(int[] array, int begin, int end) {
        if (begin > end) {
            return;
        }
        int key = array[begin];
        int high = end;
        int low = begin;
        while (begin < end) {
            while (begin < end && key <= array[end]) {
                end --;
            }
            if (begin < end) {
                array[begin] = array[end];
                begin ++;
            }
            while(begin < end && array[begin] < key) {
                begin ++;
            }
            if (begin < end) {
                array[end] = array[begin];
                end --;
            }
        }
        array[begin] = key;
        quicksort(array, low, begin-1);
        quicksort(array, begin+1, high);
    }
}
