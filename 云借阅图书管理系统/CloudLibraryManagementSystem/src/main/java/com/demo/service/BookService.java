package com.demo.service;

import com.demo.domain.Book;
import com.demo.domain.User;
import com.demo.entity.PageResult;
import com.github.pagehelper.Page;

/**
 * 图书接口
 */
public interface BookService {

    // 查询最新上架的图书
    PageResult selectNewBooks(Integer pageNum, Integer pageSize);

    // 根据id查询图书信息
    Book findBookById(String id);

    // 借阅图书
    Integer borrowBook(Book book);

    // 查询图书
    PageResult search(Book book, Integer pageNum, Integer pageSize);

    // 新增图书
    Integer addBook(Book book);

    // 编辑图书
    Integer editBook(Book book);

    // 查询当前借阅的图书
    PageResult searchBorrowed(Book book, User user ,Integer pageNum,Integer pageSize);

    // 归还图书（本质就是修改图书的状态）直接复用BookMapper接口的editBook方法
    Boolean returnBook(String id,User user);

    // 确认归还（本质就是修改图书的状态）直接复用BookMapper接口的editBook方法
    Integer returnConfirm(String id);


}
