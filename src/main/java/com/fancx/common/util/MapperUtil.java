package com.fancx.common.util;

import com.fancx.common.enums.Pagination;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MapperUtil {
    /**
     * 把前端传来的moduleName转换为表示数据库表的tableName
     *
     * @param moduleName
     * @return
     */
    public String moduleNameToTableName(String moduleName) {
        StringBuilder sb = new StringBuilder("pms_");
        sb.append(moduleName.toLowerCase());
        sb.append("_images");
        return sb.toString();
    }

    public int computePageCount(int count) {
        int x = count / Pagination.PAGE_SIZE.getPageSize();
        int y = count % Pagination.PAGE_SIZE.getPageSize();
        int pageCount = x + (y == 0 ? 0 : 1);
        return pageCount;

    }
}
