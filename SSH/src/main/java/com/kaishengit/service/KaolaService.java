package com.kaishengit.service;

import com.kaishengit.pojo.Kaola;
import com.kaishengit.util.Page;
import com.kaishengit.util.RequestQuery;

import java.util.List;

/**
 * Created by zhangyu on 2017/11/29.
 */
public interface KaolaService {
    /**
     * 查找全部考拉对象
     * @return
     */
    List<Kaola> findAll();

    /**
     * 添加对象
     * @param kaola
     */
    void saveKaola(Kaola kaola);

    /**
     * 根据id查找对象
     * @param id
     * @return
     */
    Kaola findById(Integer id);


    List<Kaola> findByRequestQuery(List<RequestQuery> requestQueryList);


    Page<Kaola> findPageByRequestQuery(List<RequestQuery> requestQueryList, Integer pageNum);
}
