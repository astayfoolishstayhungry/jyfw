package com.jyfw.jyfwser.pojo.vo;

import lombok.Data;

/**
 * @author: chunxiao
 * @description:
 * @date: created in 13:41 2018/5/6
 */
@Data
public class NewsVO {

    public String uniquekey;
    public String title;
    public String data;
    public String category;
    public String author_name;
    public String url;
    public String thumbnail_pic_s;
    public String thumbnail_pic_s02 = null;
    public String thumbnail_pic_s03 = null;

}
