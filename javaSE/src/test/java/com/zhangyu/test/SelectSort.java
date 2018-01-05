package com.zhangyu.test;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {23,32,14,16,78};

        for (int i = 0;i < nums.length - 1;i++) {
            for (int j = i + 1;j < nums.length;j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int n : nums) {
            System.out.println(n);
        }



    }


}
