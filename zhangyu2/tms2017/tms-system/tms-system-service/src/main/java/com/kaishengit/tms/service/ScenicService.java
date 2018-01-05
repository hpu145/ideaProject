package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.Scenic;
import com.kaishengit.tms.entity.ScenicAccount;

import java.io.InputStream;
import java.util.List;

public interface ScenicService {
    /**
     * 查询所有景点信息
     * @return
     */
    PageInfo<Scenic> findAll();
    /**
     * 根据id查找对应景区信息
     * @param id
     * @return
     */
    Scenic findScenicById(Integer id);

    /**
     * 修改景区信息
     * @param id
     * @param scenic
     */
    void editScenic(Integer id, Scenic scenic);
    /**
     * 根据景区id删除景区
     * @param id
     */
    void deleteScenicById(Integer id);
    /**
     * 添加景区
     * @return
     */
    Integer newScenic(Scenic scenic);

    /**
     * 添加景区账号
     * @param scenicAccount
     * @param scenicId
     */
    void addScenicAccount(ScenicAccount scenicAccount, Integer scenicId);

    /**
     * 根据景区id查询ScenicAccount
     * @param scenicId
     */
    ScenicAccount findScenicAccountByScenicId(Integer scenicId);
}
