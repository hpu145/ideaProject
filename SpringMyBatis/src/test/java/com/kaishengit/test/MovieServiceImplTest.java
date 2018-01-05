package com.kaishengit.test;

import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import com.kaishengit.service.impl.MovieServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zhangyu on 2017/10/31.
 */
public class MovieServiceImplTest extends BaseTest{
    @Autowired
    private MovieServiceImpl movieServiceImpl;
    @Test
    public void findById() throws Exception {
        Movie movie = movieServiceImpl.findById(1);
        System.out.println(movie);
    }
}