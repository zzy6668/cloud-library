package com.demo.mapper;

import com.demo.domain.Record;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


/**
 * 借阅记录接口
 */
public interface RecordMapper {

    /**
     * 新增借阅记录
     *
     * @param record 记录
     * @return {@link Integer}
     */
    Integer addRecord(Record record);


    /**
     * 查询借阅记录
     *
     * @param record 记录
     * @return {@link Page}<{@link Record}>
     */
    @Select("<script>\n" +
            "        select * from record\n" +
            "        <where>\n" +
            "            <if test=\"bookBorrower!=null\">\n" +
            "                and record_borrower like concat('%',#{bookBorrower},'%')\n" +
            "            </if>\n" +
            "            <if test=\"bookName!=null\">\n" +
            "                and record_bookname like concat('%',#{bookName},'%')\n" +
            "            </if>\n" +
            "        </where>\n" +
            "        order by record_remandtime desc\n" +
            "</script>")
    @Results(id="RecordMap",value = {
                    @Result(id = true, column = "record-id", property = "id"),
                    @Result(column = "record_bookname", property = "bookName"),
                    @Result(column = "record_bookisbn", property = "bookIsbn"),
                    @Result(column = "record_borrower", property = "bookBorrower"),
                    @Result(column = "record_borrowetime", property = "borrowTime"),
                    @Result(column = "record_remandtime", property = "remandTime")

    })
    Page<Record> searchRecords(Record record);
}
