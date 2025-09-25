package com.demo.entity;

import java.io.Serializable;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.entity
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-22  08:35
 * @Description: TODO
 * @Version: 1.0
 */

/**
 * 用于向页面传递信息
 * @param <T>
 */
public class Result<T> implements Serializable {

    // 标识是否成功操作
    private Boolean success;

    // 需要传递的信息
    private String message;

    // 需要传递的数据
    private T data;

    public Result(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public Result(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
