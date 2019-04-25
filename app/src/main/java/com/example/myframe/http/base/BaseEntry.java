package com.example.myframe.http.base;


import com.example.myframe.http.utils.MainUtil;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class BaseEntry<T> {

    private int code;
    private String message;
    private T data;

    public boolean isSuccess(){
        return getCode()== MainUtil.SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
