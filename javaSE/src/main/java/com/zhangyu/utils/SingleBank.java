package com.zhangyu.utils;

/**
 * 单例模式
 * Created by zhangyu on 2017/11/25.
 */
public class SingleBank {


    private static SingleBank singleBank;
    public SingleBank() {}

    public static SingleBank getInstance() {
        if (singleBank == null) {
            singleBank = new SingleBank();
        }
        return singleBank;
    }

}
