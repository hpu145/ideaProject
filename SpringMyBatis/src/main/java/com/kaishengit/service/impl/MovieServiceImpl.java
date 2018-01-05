package com.kaishengit.service.impl;

import com.kaishengit.entity.Movie;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by zhangyu on 2017/10/31.
 */
@Component
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public Movie findById(Integer id) {
        return  movieMapper.selectByPrimaryKey(id);
    }
}
