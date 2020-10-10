package com.oldaz.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author OldAZ-PC
 * 基数排序
 * 先排个位数——>再排十位数->。。。
 */
public class RadixSort {
    public static int[] radixSort(int[] arr){
        //判断数组是否为空或者长度小于2；
        if (arr==null||arr.length<2){return arr;}
        int n = arr.length;
        int max = arr[0];
        //找出最大值
        for (int i = 0; i < n; i++) {
            if (max<arr[i]){max = arr[i];}
        }

        //计算最大值为几位数
        int num = 1;
        while (max/10>0){
            num++;
            max=max/10;
        }

        //创建10个桶
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        //进行每一趟排序，从个位数开始排
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                int radix =  (arr[j]/(int)Math.pow(10,i-1))%10;
                //放进对应的桶里面
                bucketList.get(radix).add(arr[j]);
            }
            //合并放回原来的数组
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer t :bucketList.get(j)) {
                    arr[k++] = t;
                }
                //桶里面的数据合并之后清理桶里面的数据
                bucketList.get(j).clear();
            }

        }

        return arr;
    }
}
