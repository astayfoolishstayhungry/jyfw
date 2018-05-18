package com.jyfw.jyfwser.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @date: created in 13:54 2018/5/6
 */
@Data
public class JuHeResult<T> {

    private String stat;
    private List<T> data;

}
