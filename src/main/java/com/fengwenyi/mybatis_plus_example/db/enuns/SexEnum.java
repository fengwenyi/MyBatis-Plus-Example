package com.fengwenyi.mybatis_plus_example.db.enuns;

import lombok.Getter;

/**
 * @author Erwin Feng
 * @since 2020/5/30
 */
@Getter
public enum SexEnum {
    UNKNOWN(0, "-")
    , MALE(1, "男")
    , FEMALE(2, "女")
    ;

    /** 代码 */
    private Integer code;

    /** 值 */
    private String value;

    SexEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
