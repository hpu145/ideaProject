package com.kaishengit.util;

import java.util.List;

public class Page<T> {

    //起始行号
    private Integer start;
    //一页显示多少
    private Integer pageSize;
    //总共多少条记录
    private Integer total;
    //总共分几页
    private Integer totalPageSize;
    //第几页
    private Integer pageNum;
    //当前页的数据
    private List<T> items;

    public Page() {}

    public Page(int totalSize, Integer pageSize, Integer pageNum) {
        total = totalSize;

        //计算总页数
        totalPageSize = totalSize / pageSize;
        if(totalSize % pageSize > 0) {
            totalPageSize++;
        }

        if(pageNum < 1) {
            pageNum = 1;
        }
        if(pageNum > totalPageSize) {
            pageNum = totalPageSize;
        }
        if(totalPageSize == 0) {
            pageNum = 1;
        }
        //计算起始行数
        //1 0 1 0
        //2 10 10
        start = (pageNum - 1) * pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(Integer totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}