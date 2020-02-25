package com.macro.mall.tiny.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PageSearch{
    @NotNull(message = "pageNum不能为空")
    @Min(value = 1, message = "pageNum不能小于1")
    public int pageNum;
    @NotNull
    @Min(value = 1, message = "pageSize不能小于1")
    public int pageSize;
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



}
