package com.kaishengit.dao;

import com.kaishengit.pojo.Kaola;
import com.kaishengit.util.Page;
import com.kaishengit.util.RequestQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/30.
 */

public abstract class BaseDao<T,PK extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    public BaseDao() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    //保存或修改
    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }
    //根据id查找
    public T findById(PK id) {
        return (T) getSession().get(entityClass,id);
    }
    //删除
    public void deleteById(PK id) {
        getSession().delete(findById(id));
    }
    public void delete(T entity) {
        getSession().delete(entity);
    }
    //查找全部
    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(entityClass);
        return criteria.list();
    }
    //分页查找
    public List<T> findByPage(Integer start,Integer size) {
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setFirstResult(start);
        criteria.setMaxResults(size);
        return criteria.list();
    }



    public List<Kaola> findByRequestQueryList(List<RequestQuery> requestQueryList) {
        Criteria criteria = getSession().createCriteria(entityClass);
        buildQueryCondition(requestQueryList, criteria);
        return criteria.list();
    }

    private Criterion createCriterion(String parameterName, String compareType, Object value) {
        if("eq".equalsIgnoreCase(compareType)) {
            return Restrictions.eq(parameterName,value);
        } else if("like".equalsIgnoreCase(compareType)) {
            return Restrictions.like(parameterName,value.toString(), MatchMode.ANYWHERE);
        } else if("gt".equalsIgnoreCase(compareType)) {
            return Restrictions.gt(parameterName,value);
        } else if("ge".equalsIgnoreCase(compareType)) {
            return Restrictions.ge(parameterName,value);
        } else if("lt".equalsIgnoreCase(compareType)) {
            return Restrictions.lt(parameterName,value);
        } else if("le".equalsIgnoreCase(compareType)) {
            return Restrictions.le(parameterName,value);
        }
        return null;

    }

    /**
     *查询所有记录的总行数
     * @return
     */
    public Long count() {
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    /**
     * 根据查询条件查找符合条件的记录的总行数
     * @param requestQueryList
     * @return
     */
    public Long count(List<RequestQuery> requestQueryList) {
        Criteria criteria = getSession().createCriteria(entityClass);
        buildQueryCondition(requestQueryList, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    /**
     * 对查询条件requestQueryList处理
     * @param requestQueryList
     * @param criteria
     */
    private void buildQueryCondition(List<RequestQuery> requestQueryList, Criteria criteria) {
        for(RequestQuery query : requestQueryList) {
            String parameterName = query.getParameterName();
            String compareType = query.getCompareType();
            Object value = query.getValue();
            criteria.add(createCriterion(parameterName,compareType,value));
        }
    }

    /**
     * 根据查询条件与页号进行分页
     * @param requestQueryList
     * @param pageNum
     * @return
     */
    public Page<T> findPageByRequestQuery(List<RequestQuery> requestQueryList, Integer pageNum) {
        //1.根据查询条件，计算出总记录数是多少
        Long count = count(requestQueryList);
        //2.根据总记录数计算出总的页数
        Page<T> page = new Page<T>(count.intValue(),10,pageNum);
        //3.给定页号获取起始行号 page的构造方法以及计算出
        //4.查询
        Criteria criteria = getSession().createCriteria(entityClass);
        buildQueryCondition(requestQueryList,criteria);

        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(10);

        List<T> lists = criteria.list();
        page.setItems(lists);
        return page;


    }
}
