package com.demo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.entity
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  21:41
 * @Description: TODO
 * @Version: 1.0
 */

/**
 * 分页结果的实体类
 */
public class PageResult implements Serializable {

    // 总数
    private Long total;
    // 返回的数据集合
    private List rows;

    public PageResult(Long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
