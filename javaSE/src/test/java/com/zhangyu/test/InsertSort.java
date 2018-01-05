package com.zhangyu.test;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {23,12,67,21,31};
        //控制轮数，从第二个数字开始（下标为1）
        for(int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[j];//将要插入的值存储到临时变量
            //1.当要插入的值比前面的值小的时候进入循环
            //2.通过j>0 短路操作避免出现nums[-1]的情况

            while(j > 0 && temp < nums[j-1]) {
                nums[j] = nums[j-1];//把前一个数字替换到当前位置上
                j--;//修改j变量的值
            }
            nums[j] = temp;//将临时变量的值赋值给对应的下标
        }

        for (int n : nums) {
            System.out.println(n);
        }


    }


}
