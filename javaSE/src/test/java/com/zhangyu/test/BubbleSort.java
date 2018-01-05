package com.zhangyu.test;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {28,18,79,65,32};
        int temp;
        //控制比较多少轮
        for (int i = 0;i < nums.length - 1;i++) {
            //控制每轮的比较次数
            for (int j = 0;j < nums.length - 1 - i;j++) {
                if (nums[j] >nums[j+1]) {
                    //两数互换
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        //迭代输出排序后的数组
        for (int n : nums) {
            System.out.println(n);
        }


    }

}
