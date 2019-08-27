package com.fengwenyi.mybatis_plus_example.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <类说明>
 * <p>
 * <功能详细描述>
 *
 * @author Wenyi Feng
 * @since 2018-09-01
 */
public enum GenderEnum implements IEnum<Integer> {

    SECRECY(0, "保密"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    UNKNOWN(3, "未知")
    ;

    private Integer value;
    private String desc;

    GenderEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }



    /**
     * 通过value获取enum
     * @param value enum-value
     * @return enum
     */
    public static GenderEnum getEnumByValue(Integer value) {
        for (GenderEnum obj : GenderEnum.values())
            if (obj.value.equals(value))
                return obj;

        // 没有找到
        return GenderEnum.UNKNOWN;
    }

    public static GenderEnum getEnumByDesc(String desc) {
        for (GenderEnum obj : GenderEnum.values())
            if (obj.desc.equals(desc))
                return obj;

        // 没有找到
        return GenderEnum.UNKNOWN;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @JsonValue
    public String getDesc() {
        return desc;
    }
}
