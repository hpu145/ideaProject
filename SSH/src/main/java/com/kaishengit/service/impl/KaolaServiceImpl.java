package com.kaishengit.service.impl;

import com.kaishengit.dao.KaolaDao;
import com.kaishengit.pojo.Kaola;
import com.kaishengit.service.KaolaService;
import com.kaishengit.util.Page;
import com.kaishengit.util.RequestQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangyu on 2017/11/29.
 */
@Service
@Transactional
public class KaolaServiceImpl implements KaolaService {

    @Autowired
    private KaolaDao kaolaDao;

    /**
     * 查找全部考拉对象
     * @return
     */
    @Override
    public List<Kaola> findAll() {
        return kaolaDao.findByPage(0,100);
    }

    /**
     * 添加对象
     * @param kaola
     */
    @Override
    public void saveKaola(Kaola kaola) {
        kaolaDao.save(kaola);
    }

    /**
     * 根据id查找对象
     * @param id
     * @return
     */
    @Override
    public Kaola findById(Integer id) {
        return kaolaDao.findById(id);
    }

    @Override
    public List<Kaola> findByRequestQuery(List<RequestQuery> requestQueryList) {
        return kaolaDao.findByRequestQueryList(requestQueryList);
    }


    @Override
    public Page<Kaola> findPageByRequestQuery(List<RequestQuery> requestQueryList, Integer pageNum) {
        return kaolaDao.findPageByRequestQuery(requestQueryList,pageNum);
    }


}
