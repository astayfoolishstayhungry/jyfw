package com.jyfw.jyfwser.pojo.em;

/**
 * @description: 需求状态管理
 * @date: created in 17:11 2018/4/29
 */
public enum CommentTypeEnum {

        NEWS(1, "新闻"), TOPIC(2, "话题")
        ;
        private Integer code;
        private String message;

        private CommentTypeEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

}
