package com.oldaz.algorithm;

/**
 * @author OldAZ-PC
 * 选择排序 选择最小的排前面
 */
public class SelectSort {
    public static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if(a[min] > a[j]) {min = j;}
            }
            //交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
}
