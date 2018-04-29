package com.jyfw.jyfwser.pojo.em;

/**
 * @description: 需求状态管理
 * @date: created in 17:11 2018/4/29
 */
public enum DemandStatusEnum {

        UNVALIDATOR(0, "已保存"), VALIDATOR(1, "发布/展示"),
        VALIDATORING(2, "匹配成功"), VALIDATOR_FAILED(3, "已失效")
        ;
        private Integer code;
        private String message;

        private DemandStatusEnum(Integer code, String message) {
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
