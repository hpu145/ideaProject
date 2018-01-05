package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/4.
 */
public interface KaolaService {

    PageInfo<Kaola> findByPageNo(Integer pageNo);
    PageInfo<Kaola> findByPageNo(Integer pageNo, Map<String,Object> searchParam);
    List<String> findPlaceList();
    Kaola findById(Integer id);
    void save(Kaola kaola);
    List<KaolaType> findAllType();
    void edit(Kaola kaola);
    void deleteById(Integer id);


}
