package com.oldaz.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author OldAZ-PC
 * 计算数组的值的范围->计算桶的长度->桶的个数->装入桶
 * ->排序->取出
 *
 */
public class BucketSort {
 public int[] bucketSort(int[] arr){
     //判断是否为空和长度是否小于1；不是则继续排序操作
     if (arr==null||arr.length<2){return arr;}
     int n = arr.length;
     int max = arr[0];
     int min = arr[0];
     //寻找数组的最大值与最小值
     for (int i = 0; i < n; i++) {
         if (max<arr[i]){max = arr[i];}
         if (min>arr[i]){min = arr[i];}
     }
     //在 n 个数下，形成的两两相邻区间是 n - 1 个
     int len=max-min;   //区间总长度
     int bucketLen = len/n+1;  //桶长度 = 区间总长度 / 区间总个数 +1
     int basketNum = len/bucketLen+1; //桶个数 = 区间总长度 / 桶长度 +1
     // 这里考虑到实现的方便，多加了1个桶
     //创建桶，第i桶存放bucketSize*i~bucketSize*(i+1)-1范围的数
     ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(basketNum);
     //初始化桶
     for (int i = 0; i < basketNum; i++) {
         bucketList.add(new LinkedList<Integer>());
     }
     //遍历原数组
     for (int i = 0; i < n; i++) {
         bucketList.get((arr[i]-min)/len).add(arr[i]-min);
     }
     //对桶内的元素进行排序，我这里采用自带的排序工具
     for (int i = 0; i <basketNum; i++) {
        Collections.sort(bucketList.get(i));
     }
     //把每个桶排好序的数组合并汇总放回原数组
     int k=0;
     for (int i = 0; i < basketNum; i++) {
         for (Integer t :bucketList.get(i)){
             arr[k++] = t + min;
         }
     }
     return arr;
 }
}
