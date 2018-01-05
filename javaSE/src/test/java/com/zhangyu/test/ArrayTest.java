package com.zhangyu.test;

import com.zhangyu.utils.ArrayUtils;
import org.junit.Test;

/**
 * Created by zhangyu on 2017/10/30.
 */
public class ArrayTest {

    //1.获取数组中的最大值问题
    @Test
    public void getMax() {
        int[] nums = {12,16,10,22,80,15};
        int max = ArrayUtils.getMax(nums);
        System.out.println("max:" + max);
    }
    //2.选择排序
    @Test
    public void selectSort() {
        int[] nums = {12,16,10,22,80,15};
        int[] arr = ArrayUtils.selectSort(nums);
        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i] + ",");
        }
    }




}
