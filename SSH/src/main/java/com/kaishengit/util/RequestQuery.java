package com.kaishengit.util;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/30.
 */

public class RequestQuery {

    private String parameterName;
    private String compareType;
    private Object value;
    // get set


    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getCompareType() {
        return compareType;
    }

    public void setCompareType(String compareType) {
        this.compareType = compareType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static List<RequestQuery> buildRequestQuery(HttpServletRequest request)
            throws IllegalAccessException {
        List<RequestQuery> requestQueryList = new ArrayList<>();
        //获取所有查询参数的键值
        Enumeration<String> enumeration = request.getParameterNames();
        while(enumeration.hasMoreElements()) {
            String queryKey = enumeration.nextElement();
            String value = request.getParameter(queryKey);
            if (queryKey.startsWith("q_") && !"".equals(value) && value != null) {
                //q_productName_like_s
                String[] array = queryKey.split("_");
                if (array == null && array.length != 4) {
                    throw new IllegalAccessException("查询条件异常：" + queryKey);
                }
                RequestQuery query = new RequestQuery();
                query.setParameterName(array[1]);
                query.setCompareType(array[2]);
                query.setValue(transValueType(array[3],value));
                requestQueryList.add(query);
            }
        }
        return requestQueryList;
    }

    //将查询参数的value值进行转化的方法
    private static Object transValueType(String valueType,String value) {
        if ("s".equalsIgnoreCase(valueType)) {
            return value;
        }
        if ("d".equalsIgnoreCase(valueType)) {
            return Double.valueOf(value);
        }
        if("f".equalsIgnoreCase(valueType)) {
            return Float.valueOf(value);
        }
        if("i".equalsIgnoreCase(valueType)) {
            return Integer.valueOf(value);
        }
        if("bd".equalsIgnoreCase(valueType)) {
            return new BigDecimal(value);
        }
        return null;
    }


}
