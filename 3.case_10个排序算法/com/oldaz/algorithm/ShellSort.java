package com.oldaz.algorithm;


/**
 * @author OldAZ-PC
 * 希尔排序  分组 两两比较排序
 */
public class ShellSort {
   public int[] shellSort(int[] arr){

       int length =  arr.length; //数组的长度，用于分组
        //循环决定比较的间隔
       for (int i =length/2; i >0 ; i=i/2){
           //根据间隔分成若干个子数组
           for (int j = i; j < length; j++) {
               //在子数组内使用插入排序算法
               for (int k = j; k >=i&& arr[k]<arr[k-i] ; k=k-i) {
                   int temp = arr[k];
                   arr[k] = arr[k-i];
                   arr[k-i] = temp;
               }
           }


       }
       return arr;
   }
}
