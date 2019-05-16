package com.graduation.manage.vo;

public class GoodsVo {

    private int pageNum = 1;

    private int pageSize = 4;

    private String keywords;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
