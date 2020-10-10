package com.oldaz.algorithm;

/**
 * @author OldAZ-PC
 * 快速排序  确定轴中元素->分组   确定轴中元素时，就在调整位置。
 */
public class QuickSort {
    public  int[] quickSort(int[] arr,int left ,int right){
        if (left<right){
            //获取轴中元素所处的位置
            int mid = parition(arr,left,right);
            //进行递归分隔
            arr = quickSort(arr,left,mid-1);
            arr = quickSort(arr, mid+1,right );
        }

        return arr;
    }

    private static int parition(int[] arr, int left, int right) {
        //选取中轴元素
        int pivot = arr[left];
        int i = left+1;
        int j = right;

        while(true){
            //向左找到第一个大于等于pivot的元素
            while (i<=j&&arr[j]>=pivot){j--;}
            //向右找到一个等于pivot的元素位置
            while(i<=j && arr[i]<=pivot){i++;}
            if (i>=j){
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[j];
        //使中轴元素处于有序位置
        arr[j] = pivot;
        return j;
    }
}
