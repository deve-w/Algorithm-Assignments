package com.company;
import java.util.Scanner;

public class insertionSort {
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
     * 插入排序
     * @param arr
     */
    public void inSort(int[] arr) {
        if (null == arr) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                }
            }
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

    public static void main(String[] args) {
        insertionSort ins = new insertionSort();
        Scanner input = new Scanner(System.in);
        System.out.println("输入Len：");
        int len = input.nextInt();
        int[] tempArr = ins.getRandomNumber(len); //获取len个随机数
        System.out.print("排序前：");

        ins.display(tempArr);
        System.out.println();

        long startTime=System.currentTimeMillis();//开始时间
        System.out.print("开始进行插入排序：");
        ins.inSort(tempArr);
        long endTime=System.currentTimeMillis();//结束时间
        float excTime=(float)(endTime-startTime);
        System.out.println("执行时间为："+excTime+"ms");

        ins.display(tempArr);

    }
}