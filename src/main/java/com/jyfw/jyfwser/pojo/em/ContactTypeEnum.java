package com.jyfw.jyfwser.pojo.em;

/**
 * @description: 需求状态管理
 * @date: created in 17:11 2018/4/29
 */
public enum ContactTypeEnum {

        NEWS(1, "进行中"), TOPIC(2, "已完成")
        ;
        private Integer code;
        private String message;

        private ContactTypeEnum(Integer code, String message) {
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
