package com.oldaz.algorithm;

/**
 * @author OldAZ-PC
 *计算 最大值和最小值
 * ->创建一个临时数组（存储数值出现的频率）
 * ->按统计好的数字汇总到原数组
 */
public class CountSort {
    public int[] countSort(int[] arr){
        if (arr==null||arr.length<2){return arr;}
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        //寻找数组的最大值//寻找数组的最小值
        for (int i=1;i<n;i++){
            if (max < arr[i]){max = arr[i];}
            if (min > arr[i]){min = arr[i];}
        }


        //创建大小为max的临时数组
        int[] temp = new int[max-min+1];

        //统计i出现的次数；
        for (int i = 0;i<n;i++){ temp[arr[i]-min]++; }
        int k = 0;

        //把临时数组统计好的数据汇总到原数组
        for (int i = 0; i <= max-min; i++) {
            for (int j = temp[i]; j > 0 ; j--) {
                arr[k++] = i+min;
            }
        }
        return arr;
    }
}
