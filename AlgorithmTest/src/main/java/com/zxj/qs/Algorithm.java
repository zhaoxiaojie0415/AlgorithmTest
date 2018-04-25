package com.zxj.qs;

/**
 * Created by qs on 2017/12/11.
 */
public class Algorithm {
    public static void main(String[] args) {
        int[] arrayneedSort =  new int[]{7,5,5,5,5};
        int begin = 0;
        int end = arrayneedSort.length -1;
        quickSort(arrayneedSort, begin, end);
        for (int i : arrayneedSort) {
            System.out.println(i);
        }

    }

    private static void quickSort(int[] arrayneedSort, int begin, int end) {
            findPartKeyPostion(arrayneedSort, begin, end);
//            quickSort(arrayneedSort, partKeyPostion + 1, end);
//            quickSort(arrayneedSort, begin, partKeyPostion -1);
//        }

    }

    private static void findPartKeyPostion(int[] arrayneedSort, int begin, int end) {
        if (begin > end) {
            return;
        }
        int low = begin;
        int high = end;
        int key = arrayneedSort[begin];;
        while (end > begin){
            while (end > begin && arrayneedSort[end] >= key)
                end --;
            if (begin < end) {
                arrayneedSort[begin] = arrayneedSort[end];
                begin ++;
            }
            while(begin < end && arrayneedSort[begin] < key)
                begin ++;
            if (end > begin) {
                arrayneedSort[end] = arrayneedSort[begin];
                end --;
            }
        }
        arrayneedSort[begin] = key;
        findPartKeyPostion(arrayneedSort, begin + 1, high);
        findPartKeyPostion(arrayneedSort, low, begin -1);
    }

}
