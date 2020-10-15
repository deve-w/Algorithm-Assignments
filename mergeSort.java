package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {
    /*
     * 生成随机数
     */
    public int[] getRandomNumber(int len) {
        if (len < 1) {
            len = 1;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    /*
      *合并排序
     @Param  arr
     */
    public static void merge_Sort(int[] arr, int low, int high, int[] tmp) {

        if (low < high) {
            int mid = (low + high) / 2;
            merge_Sort(arr, low, mid, tmp); //对左边序列进行归并排序
            merge_Sort(arr, mid + 1, high, tmp);  //对右边序列进行归并排序
            merge(arr, low, mid, high, tmp);    //合并两个有序序列
        }

    }

    public void display(int[] arr) {
        for (int i = 0; null != arr && i < arr.length; i++) {
            if (0 == i % 10) {  //输出10个数字换行输出
                System.out.println();
            }
            System.out.print(arr[i] + "  ");
        }
    }

    /*
     合并数组
     */
    public  static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low, k = mid + 1;  //左边序列和右边序列起始索引
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= high) {
            tmp[i++] = arr[k++];
        }
        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }

    }

    public static void main(String[] args) {
        mergeSort mes = new mergeSort();

        Scanner input = new Scanner(System.in);
        System.out.println("输入Len：");
        int len = input.nextInt();
        int[] tempArr = mes.getRandomNumber(len); //获取len个随机数
        System.out.print("排序前：");
        mes.display(tempArr);
        System.out.println();

        long startTime=System.currentTimeMillis();//开始时间
        System.out.print("开始进行合并排序：");
        int[] tmp = new int[tempArr.length];    //新建一个临时数组存放
        mes.merge_Sort(tempArr,0,tempArr.length-1,tmp);
        long endTime=System.currentTimeMillis();//结束时间
        float excTime=(float)(endTime-startTime);
        System.out.println("执行时间为："+excTime+"ms");

        mes.display(tempArr);
    }
}

