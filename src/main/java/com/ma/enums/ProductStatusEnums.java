package com.ma.enums;

/**
 * Created by mh on 2018/7/21.
 */
public enum ProductStatusEnums {
    UP(0,"上架"),
    DOWN(1,"下架"),
    ;
    private Integer status;
    private String message;

    ProductStatusEnums(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
