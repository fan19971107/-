package com.fancx.common.enums;

/**
 * 分页相关枚举
 */
public enum Pagination {
    PAGE_SIZE(11);
    private Integer pageSize;
    Pagination(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
