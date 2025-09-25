package com.demo.service.Impl;

import com.demo.domain.Record;
import com.demo.domain.User;
import com.demo.entity.PageResult;
import com.demo.mapper.RecordMapper;
import com.demo.service.RecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.service.Impl
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-24  15:19
 * @Description: TODO
 * @Version: 1.0
 */

@Service
public class RecordServiceImpl implements RecordService {

    // 注入RecordMapper对象
    private RecordMapper recordMapper;

    @Autowired
    public RecordServiceImpl(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }


    /**
     * 添加借阅记录
     *
     * @param record 记录
     * @return {@link Integer}
     */
    @Override
    public Integer addRecord(Record record) {

        return recordMapper.addRecord(record);
    }

    /**
     * 查询借阅记录
     *
     * @param record   当前记录的查询条件
     * @param user     当前的登录用户
     * @param pageNum  页面码
     * @param pageSize 页面长度
     * @return {@link PageResult}
     */
    @Override
    public PageResult searchRecords(Record record, User user, Integer pageNum, Integer pageSize) {

        // 设置分页查询
        PageHelper.startPage(pageNum,pageSize);

        // 判断是否为管理员
        if (!"ADMIN".equals(user.getRole())){
            /**
             * 如果不是管理员 就将查询条件中的 借阅人设置为当前登录用户
             * 如果是管理员 那么就不会运行该if 反之 若为普通用户则运行该if
             * 将条件中的借阅人设置为当前登录人
             */
            record.setBookBorrower(user.getName());
        }
        Page<Record> page = recordMapper.searchRecords(record);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
