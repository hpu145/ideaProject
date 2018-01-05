package com.kaishengit.exception;

/**
 * Created by zhangyu on 2017/12/6.
 */
public class ServiceException extends RuntimeException{

    public ServiceException(){}

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable th) {
        super(th);
    }

    public ServiceException(String message,Throwable th) {
        super(message,th);
    }

}