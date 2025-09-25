package com.demo.service;

import com.demo.domain.Record;
import com.demo.domain.User;
import com.demo.entity.PageResult;
import org.springframework.stereotype.Service;

/**
 * 借阅记录接口
 */
public interface RecordService {

    /**
     * 添加借阅记录
     *
     * @param record 记录
     * @return {@link Integer}
     */
    Integer addRecord(Record record);

    /**
     * 查询借阅记录
     *
     * @param record   记录
     * @param user     用户
     * @param pageNum  页面码
     * @param pageSize 页面大小
     * @return {@link PageResult}
     */
    PageResult searchRecords(Record record, User user,Integer pageNum,Integer pageSize);
}
