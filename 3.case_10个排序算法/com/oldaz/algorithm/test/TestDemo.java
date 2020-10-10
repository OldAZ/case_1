package com.oldaz.algorithm.test;


import com.oldaz.algorithm.*;
import org.junit.Test;
public class TestDemo {

/**
 * 测试希尔排序
 * */
    @Test
    public  void test_Shell_Sort(){
        //int arr[]= {2,3,5,7,9};  测试数据
        int arr[]= {7,7,299,2,66,43,59,699,32,17}; //测试数据 2
        ShellSort shell = new ShellSort();
        int[] ints = shell.shellSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }


/**
 * 测试归并排序
 * */
    @Test
    public  void test_Merge_Sort(){
        //int arr[]= {2,7,5,4};  //测试数据
        int arr[]= {7,7,299,2,66,43,59,699,1}; //测试数据 2
        MergeSort merge = new MergeSort();
        int[] ints = merge.mergeSort(arr,0,arr.length-1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }




/**
 * 测试快速排序
 * */
    @Test
    public  void test_Quick_Sort(){
        //int arr[]= {2,7,5,4};  //测试数据
        int arr[]= {7,7,299,2,66,43,59,699}; //测试数据 2
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.quickSort(arr,0,arr.length-1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }


/**
 * 测试堆排序
 * */
    @Test
    public  void test_Heap_Sort(){
        int arr[]= {2};  //测试数据
        //int arr[]= {7,7,299,2,66,43,59,699,1,78}; //测试数据 2
        HeadSort headSort = new HeadSort();
        int[] ints = headSort.heapSort(arr,arr.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }


/**
 * 测试计数排序
 * */
    @Test
    public  void test_Count_Sort(){
        //int arr[]= {2};  //测试数据
        int arr[]= {1,3,2,4,2,3,5,5,6,4,5,3,2,5}; //测试数据 2
        CountSort countSort = new CountSort();
        int[] ints = countSort.countSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }


/**
 * 测试桶排序
 * */
    @Test
    public  void test_Bucket_Sort(){
        //int arr[]= {2};  //测试数据
        int arr[]= {1,3,2,4,2,3,5,5,6,4,5,3,2,5};  //测试数据 2
        BucketSort bucketSort = new BucketSort();
        int[] ints = bucketSort.bucketSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }



/**
 * 测试基数排序
 * */
    @Test
    public  void test_Radix_Sort(){
        //int arr[]= {2};  //测试数据
        int arr[]= {2,55,666,8888,4,45,67867,78,2344444,645756,7856756,34535567,5678678,45,45,67,5656,34,67,45};  //测试数据 2
        int[] ints = RadixSort.radixSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }



}
