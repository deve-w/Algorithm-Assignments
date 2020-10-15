package com.company;

import java.util.Scanner;

public class quickSort {
    public static void quick_sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int baseNum = arr[low];
        while (l < h) {
            //1.从右向左查找小于指定基数的数，找到之后跳出循环执行下面if循环，交换数据
            while (l < h && arr[h] >= baseNum) {
                h--;
            }
            //交换数据
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            //2.从左向右查找大于指定基数的数，找到后跳出循环执行下面if循环，交换数据
            while (l < h && arr[l] <= baseNum)
                l++;
            //交换数据
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (l > low) {
            quick_sort(arr, low, l - 1);
        }
        if (h < high) {
            quick_sort(arr, l + 1, high);
        }
    }
    /*
     * 生成随机数
     */
    public int[] getRandomNumber(int len) {
        if (len < 1) {
            len = 1;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }
    public void display(int[] arr) {
        for (int i = 0; null != arr && i < arr.length; i++) {
            if (0 == i % 10) {  //输出10个数字换行输出
                System.out.println();
            }
            System.out.print(arr[i] + "  ");
        }
    }
    public static void main(String[] args) {
        quickSort qus = new quickSort();

        Scanner input = new Scanner(System.in);
        System.out.println("输入Len：");
        int len = input.nextInt();
        int[] tempArr = qus.getRandomNumber(len); //获取len个随机数
        System.out.print("排序前：");

        int start =0;
        qus.display(tempArr);
        System.out.println();
        long startTime=System.currentTimeMillis();//开始时间
        System.out.print("开始进行快速排序：");
        qus.quick_sort(tempArr,start,len-1);
        long endTime=System.currentTimeMillis();//结束时间
        float excTime=(float)(endTime-startTime);
        System.out.println("执行时间为："+excTime+"ms");

        qus.display(tempArr);
    }

}
