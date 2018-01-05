package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaExample;
import com.kaishengit.entity.KaolaType;
import com.kaishengit.entity.KaolaTypeExample;
import com.kaishengit.mapper.KaolaMapper;
import com.kaishengit.mapper.KaolaTypeMapper;
import com.kaishengit.service.KaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/4.
 */
@Service
public class KaolaServiceImpl implements KaolaService {

    @Autowired
    private KaolaMapper kaolaMapper;
    @Autowired
    private KaolaTypeMapper kaolaTypeMapper;

    @Override
    public PageInfo<Kaola> findByPageNo(Integer pageNo) {
        //pageNo 表示第几页
        PageHelper.startPage(pageNo,10);
        List<Kaola> kaolaList = kaolaMapper.findWithType();
        return new PageInfo<Kaola>(kaolaList);
    }

    @Override
    public List<String> findPlaceList() {
        return kaolaMapper.findPlaceList();
    }

    @Override
    public PageInfo<Kaola> findByPageNo(Integer pageNo, Map<String, Object> searchParam) {
        PageHelper.startPage(pageNo,10);
        List<Kaola> kaolaList = kaolaMapper.findBySearchParamWithType(searchParam);
        return new PageInfo<>(kaolaList);
    }

    @Override
    public Kaola findById(Integer id) {
        Kaola kaola = kaolaMapper.selectByPrimaryKey(id);
        kaola.setKaolaType(kaolaTypeMapper.selectByPrimaryKey(kaola.getTypeId()));
        return kaola;
    }

    @Override
    public void save(Kaola kaola) {
        //新添加的商品，评论默认为0
        kaola.setCommentNum(0);
        kaolaMapper.insert(kaola);
    }

    @Override
    public List<KaolaType> findAllType() {
        KaolaTypeExample kaolaTypeExample = new KaolaTypeExample();
        return kaolaTypeMapper.selectByExample(kaolaTypeExample);
    }

    @Override
    public void edit(Kaola kaola) {
        kaolaMapper.updateByPrimaryKeySelective(kaola);
    }

    @Override
    public void deleteById(Integer id) {
        kaolaMapper.deleteByPrimaryKey(id);
    }



}
