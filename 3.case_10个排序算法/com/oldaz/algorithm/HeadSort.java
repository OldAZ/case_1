package com.oldaz.algorithm;

/**
 * @author OldAZ-PC
 * 堆排序
 * 创建一个最小堆
 * 维护堆的性质
 * 取下堆顶->用最后一个值取代堆顶
 * 维护堆的性质
 */
public class HeadSort {
    public int[] heapSort(int[] arr,int length){
        //构建二叉堆（最小堆）
        for (int i = (length-2)/2; i >= 0 ; i--) {
            //维护堆的性质
            arr = downAdjust(arr,i,length);
        }


        //进行堆排序
        for (int i = length-1; i >=1 ; i--) {
            //把堆顶的元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //下沉以后，在需要进行堆的性质的维护
            arr = downAdjust(arr,0,i);
        }

        return arr;
    }

    private int[] downAdjust(int[] arr, int parent, int length) {
       //临时保存要进行下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置/ 右孩子只需要+1
        int child = 2*parent+1;

        //开始下沉维护
        while(child<length){
            //如果右孩子节点比左孩子小，则定位到右孩子
            if (child+1 <length &&arr[child]>arr[child+1]){
                child++;
            }

            //如果父节点比孩子节点小于或者等于，则下沉结束
            if (temp<=arr[child]){break;}

            //单项赋值
            arr[parent] = arr[child];
            parent = child;
            child = 2*parent+1;
        }
        arr[parent] =temp;
        return arr;
    }


}
