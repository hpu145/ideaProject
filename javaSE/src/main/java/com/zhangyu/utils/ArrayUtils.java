package com.zhangyu.utils;

/**
 * Created by zhangyu on 2017/10/30.
 */
public class ArrayUtils {
    //1.获取数组中的最大值问题
    public static int getMax(int[] arr) {

        int maxIndex = 0;
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println(arr[maxIndex]);
        return arr[maxIndex];


       /* //方法①.初始化数组中的某个元素
        int maxEle = arr[0];//初始化值不可定义为0，因为数组全部为负数时，获取最大值为0
        for(int i = 0;i < arr.length;i++) {
            if(arr[i] > maxEle) {
                maxEle = arr[i];
            }
        }
        return maxEle;*/
        //方法②.初始化数组元素的下标
        /*int maxIndex = 0;
        for (int i = 0;i < arr.length;i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];*/
    }
    //2.选择排序
    public static int[] selectSort(int[] arr) {
        for (int x = 0;x < arr.length - 1;x++ ) {
            for(int y = x+1;y < arr.length;y++) {
                if(arr[x] > arr[y]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
        return arr;
    }



}
