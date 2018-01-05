package com.kaishengit.test;

import com.kaishengit.jobs.MyTimerTask;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;

/**
 * Created by zhangyu on 2017/11/15.
 */
public class TimerTaskTestCase{

    @Test
    public void testTime() throws IOException {
        Timer timer = new Timer();
        //timer.schedule(new MyTimerTask(),0,1000);
        //timer.schedule(new MyTimerTask(),2000);
        //timer.schedule(new MyTimerTask(),new Date());
        timer.schedule(new MyTimerTask(),new Date(),2000);




        System.in.read();
    }



}
