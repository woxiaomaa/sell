package com.ma.viewobject;

import lombok.Data;

import java.util.List;

/**
 * 最外层数据
 * Created by mh on 2018/7/21.
 */
@Data
public class ResultVO<T> {
    /**0表示成功*/
    private Integer code;
    private String msg;
    private List<T> data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
