package com.demo.mapper;

import com.demo.domain.Book;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 图书接口
 */
public interface BookMapper {


    /**
     * 查询没有下架的书
     * 根据时间排序 把最新上架的书排第一
     *
     * @return {@link Page}<{@link Book}>
     */
    @Select("select * from book where book_status!=3 order by book_uploadtime desc")
    @Results(id = "BookResult", value = {
            @Result(id = true, column = "book_id", property = "id"),
            @Result(column = "book_name", property = "name"),
            @Result(column = "book_isbn", property = "isbn"),
            @Result(column = "book_press", property = "press"),
            @Result(column = "book_author", property = "author"),
            @Result(column = "book_pagination", property = "pagination"),
            @Result(column = "book_price", property = "price"),
            @Result(column = "book_uploadtime", property = "uploadTime"),
            @Result(column = "book_status", property = "status"),
            @Result(column = "book_borrower", property = "borrower"),
            @Result(column = "book_borrowtime", property = "borrowTime"),
            @Result(column = "book_returntime", property = "returnTime"),
    })
    Page<Book> selectNewBooks();



    /**
     * 借阅图书
     */

    @Select("select * from book where book_id = #{id}")
    @ResultMap("BookResult")
    // 根据id查询图书信息
    Book findBookById(String id);



    /**
     * 编辑图书
     * @param book
     * @return
     */
    Integer editBook(Book book);



    /**
     * 查询图书
     * @param book
     * @return
     */
    @Select("<script>\n" +
            "            select * from book\n" +
            "            <where>\n" +
            "                <if test=\"name!=null and  name.trim()!=''\">\n" +
            "                    and book_name like concat('%',#{name},'%')\n" +
            "                </if>\n" +
            "                <if test=\"author!=null and author.trim()!=''\">\n" +
            "                    and book_author like concat('%',#{author},'%')\n" +
            "                </if>\n" +
            "                <if test=\"press!=null and press.trim()!=''\">\n" +
            "                    and book_press like concat('%',#{press},'%')\n" +
            "                </if>\n" +
            "            </where>\n" +
            "            order by book_status\n" +
            "        </script>")
    @ResultMap("BookResult")
    Page<Book> searchBooks(Book book);


    /**
     * 添加图书
     *
     * @param book 书
     * @return {@link Integer}
     */
    Integer addBook(Book book);


    /**
     * 查询当前借阅人和所有待归还中的图书
     * 用于管理员查询
     * @param book 书
     * @return {@link Page}<{@link Book}>
     */
    @Select("<script>\n" +
            "        select *\n" +
            "        from book\n" +
            "        where book_borrower = #{borrower}\n" +
            "        and book_status = '1'\n" +
            "        <if test=\"name!=null and name.trim()!=''\">\n" +
            "            and book_name like concat('%',#{name},'%')\n" +
            "        </if>\n" +
            "        <if test=\"press!=null and press.trim()!=''\">\n" +
            "            and book_press like concat('%',#{press},'%')\n" +
            "        </if>\n" +
            "        <if test=\"author!=null and author.trim()!=''\">\n" +
            "            and book_author like concat('%',#{author},'%')\n" +
            "        </if>\n" +
            "        or book_status='2'\n" +
            "        <if test=\"name!=null and name.trim()!=''\">\n" +
            "            and book_name like concat('%',#{name},'%')\n" +
            "        </if>\n" +
            "        <if test=\"press!=null and press.trim()!=''\">\n" +
            "            and book_press like concat('%',#{press},'%')\n" +
            "        </if>\n" +
            "        <if test=\"author!=null and author.trim()!=''\">\n" +
            "            and book_author like concat('%',#{author},'%')\n" +
            "        </if>\n" +
            "        order by book_borrowtime\n" +
            "</script>")
    @ResultMap("BookResult")
    Page<Book> selectBorrowed(Book book);



    /**
     * 查询当前借阅图书的人和当前未归还的图书
     * 用于普通用户
     * @param book 书
     * @return {@link Page}<{@link Book}>
     */
    @Select("<script>\n" +
            "        select *\n" +
            "        from book\n" +
            "        where book_borrower = #{borrower}\n" +
            "        and book_status in('1','2')\n" +
            "        <if test=\"name!=null and name.trim()!=''\">\n" +
            "            and book_name like concat('%',#{name},'%')\n" +
            "        </if>\n" +
            "        <if test=\"press!=null and press.trim()!=''\">\n" +
            "            and book_press like concat('%',#{press},'%')\n" +
            "        </if>\n" +
            "        <if test=\"author!=null and author.trim()!=''\">\n" +
            "            and book_author like concat('%',#{author},'%')\n" +
            "        </if>\n" +
            "        order by book_borrowtime\n" +
            "</script>")
    @ResultMap("BookResult")
    Page<Book> selectMyBorrowed(Book book);
}
