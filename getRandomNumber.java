package com.company;

public class getRandomNumber {
    public int[] getRandomNumber(int len){
        if (len<1){
            len = 1;
        }
        int[] arr = new int[len];
        for(int i = 0;i<len;i++){
            arr[i] = (int)(Math.random()*1000);
        }
        return arr;
    }
}
