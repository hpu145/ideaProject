package com.kaishengit.tms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.Scenic;
import com.kaishengit.tms.entity.ScenicAccount;
import com.kaishengit.tms.entity.ScenicAccountExample;
import com.kaishengit.tms.entity.ScenicExample;
import com.kaishengit.tms.mapper.ScenicAccountMapper;
import com.kaishengit.tms.mapper.ScenicMapper;
import com.kaishengit.tms.service.ScenicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScenicServiceImpl implements ScenicService {

    private Logger logger = LoggerFactory.getLogger(ScenicServiceImpl.class);
    @Autowired
    private ScenicMapper scenicMapper;
    @Autowired
    private ScenicAccountMapper scenicAccountMapper;

    /**
     * 查询所有景点信息
     * @return
     */
    @Override
    public PageInfo<Scenic> findAll() {
        ScenicExample scenicExample = new ScenicExample();
        List<Scenic> scenicList = scenicMapper.selectByExample(scenicExample);
        PageHelper.startPage(1,10);
        return new PageInfo<>(scenicList);
    }
    /**
     * 根据id查找对应景区信息
     * @param id
     * @return
     */
    @Override
    public Scenic findScenicById(Integer id) {
        return scenicMapper.selectByPrimaryKey(id);
    }
    /**
     * 修改景区信息
     * @param id
     * @param scenic
     */
    @Override
    public void editScenic(Integer id, Scenic scenic) {
        scenic.setUpdateTime(new Date());
        //保存到数据库
        scenicMapper.updateByPrimaryKey(scenic);
        logger.info("{}修改了景区信息",scenic.getScenicAccountId());
    }

    /**
     * 根据景区id删除景区
     * @param id
     */
    @Override
    @Transactional
    public void deleteScenicById(Integer id) {
        Scenic scenic = findScenicById(id);
        //删除景区对应的账户
        ScenicAccount scenicAccount = findScenicAccountByScenicId(scenic.getId());
        if (scenicAccount != null) {
            scenicAccountMapper.deleteByPrimaryKey(scenicAccount.getId());
            scenicMapper.deleteByPrimaryKey(id);
        } else {
            scenicMapper.deleteByPrimaryKey(id);
        }

    }

    /**
     * 添加景区
     * @return
     */
    @Override
    public Integer newScenic(Scenic scenic) {
        scenic.setCreateTime(new Date());
        scenicMapper.insertSelective(scenic);
        return scenic.getId();
    }
    /**
     * 添加景区账号
     * @param scenicAccount
     * @param scenicId
     */
    @Override
    public void addScenicAccount(ScenicAccount scenicAccount, Integer scenicId) {
        scenicAccount.setCreateTime(new Date());
        scenicAccount.setUpdateTime(new Date());
        scenicAccount.setScenicId(scenicId);
        scenicAccountMapper.insertSelective(scenicAccount);
    }
    /**
     * 根据景区id查询ScenicAccount
     * @param scenicId
     */
    @Override
    public ScenicAccount findScenicAccountByScenicId(Integer scenicId) {
        ScenicAccountExample example = new ScenicAccountExample();
        example.createCriteria().andScenicIdEqualTo(scenicId);
        List<ScenicAccount> scenicAccounts = scenicAccountMapper.selectByExample(example);
        ScenicAccount scenicAccount = null;
        if (scenicAccounts != null && !scenicAccounts.isEmpty()) {
            scenicAccount = scenicAccounts.get(0);
        }
        return scenicAccount;

    }


}
