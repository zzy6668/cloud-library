package com.demo.domain;

import java.io.Serializable;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.entity
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  21:10
 * @Description: TODO
 * @Version: 1.0
 */
public class Book implements Serializable {

    // 图书编号
    private Integer id;
    // 图书名称
    private String name;
    // 图书标准国际编号
    private String isbn;
    // 图书出版社
    private String press;
    // 图书作者
    private String author;
    // 图书页数
    private Integer pagination;
    // 图书价格
    private Double price;
    // 图书上架时间
    private String uploadTime;
    // 图书状态
    private String status;
    // 图书借阅人
    private String borrower;
    // 图书借阅时间
    private String borrowTime;
    // 图书预计的归回时间
    private String returnTime;

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", pagination=" + pagination +
                ", price=" + price +
                ", uploadTime='" + uploadTime + '\'' +
                ", status='" + status + '\'' +
                ", borrower='" + borrower + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPagination() {
        return pagination;
    }

    public void setPagination(Integer pagination) {
        this.pagination = pagination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
}
