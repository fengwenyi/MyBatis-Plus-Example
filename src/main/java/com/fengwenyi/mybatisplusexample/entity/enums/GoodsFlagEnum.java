package com.fengwenyi.mybatisplusexample.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author Erwin Feng
 * @since 2021-03-08
 */
@Getter
public enum GoodsFlagEnum implements IEnum<Integer> {
    DOWN(0, "下架"),
    UP(1, "上架"),
    ;

    private final Integer value;

    private final String desc;

    GoodsFlagEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
