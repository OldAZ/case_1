package com.oldaz.algorithm;


import java.util.Stack;

/**
 * @author OldAZ-PC
 * 归并算法 递归 分组->排序->合并
 */
public class MergeSort {
    public int[] mergeSort(int[] arr , int left , int right) {
        if (left < right) { //判断left和right，若相等则，不用继续分组
            //寻找分组的标识
            int mid = (left + right) /2 ;
            //为左边进行递归调用，继续分组
            arr = mergeSort(arr,left,mid);
            //为右边进行递归调用继续分组
            arr = mergeSort(arr,mid+1,right);
            //调用排序分组，合并，每一个部分都会调用此方法。
            Merge(arr,left,mid,right);
        }
            return arr;
    }

    // 合并函数，把两个有序的数组合并起来
    // arr[left..mid]表示一个数组，arr[mid+1 .. right]表示一个数组
    private static void Merge(int[] arr,int left,int mid,int right) {
        int l = left; //用于判断数组定位
        int m = mid+1; ////用于判断数组定位
        int i = 0; //新数组的坐标
        int[] a = new int[right-left+1]; //此数组用于排序
        while (l<=mid&&m<=right){ // 若左右两组数组都存在值，则进行大小判断
            if (arr[l]>arr[m]){
                a[i++]=arr[m++];
            }else {
                a[i++]=arr[l++];
            }
        }
        while (l<=mid){a[i++]=arr[l++];} //若只有左边数组存在值，则将其搬运到新数组
        while (m<=right){a[i++]=arr[m++];}

        for (int j = 0; j < i; j++) { //将排好序的新数组，重新赋值给原数组
            arr[left++]=a[j];
        }
    }
}
