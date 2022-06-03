package com.fancx.Common.Enum;

import lombok.Data;

/**
 * 分页相关枚举
 */
public enum Pagination {
    Category_PageSize(7);
    private Integer pageSize;
    Pagination(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
