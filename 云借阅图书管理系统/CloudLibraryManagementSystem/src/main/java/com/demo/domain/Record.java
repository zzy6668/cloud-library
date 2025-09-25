package com.demo.domain;

import java.io.Serializable;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.entity
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  21:11
 * @Description: TODO
 * @Version: 1.0
 */
public class Record implements Serializable {
    // 图书借阅的id
    private Integer id;
    // 借阅的图书的名称
    private String bookName;
    // 借阅图书的ISBN
    private String bookIsbn;
    // 图书的借阅人
    private String bookBorrower;
    // 图书借阅的时间
    private String borrowTime;
    // 图书的归还时间
    private String remandTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookBorrower() {
        return bookBorrower;
    }

    public void setBookBorrower(String bookBorrower) {
        this.bookBorrower = bookBorrower;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getRemandTime() {
        return remandTime;
    }

    public void setRemandTime(String remandTime) {
        this.remandTime = remandTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookBorrower='" + bookBorrower + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", remandTime='" + remandTime + '\'' +
                '}';
    }
}
