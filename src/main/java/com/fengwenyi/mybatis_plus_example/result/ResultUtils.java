package com.fengwenyi.mybatis_plus_example.result;

import com.fengwenyi.api_result.helper.ResultHelper;
import com.fengwenyi.api_result.model.ResultModel;

/**
 * 接口响应结果工具类
 * @author Erwin Feng
 * @since 2020/5/30
 */
public class ResultUtils {

    /** 成功提示信息 */
    private static final String SUCCESS_MESSAGE = "Success";

    /**
     * 成功
     * @return {@link ResultModel}
     */
    public static ResultModel<Void> success() {
        return ResultHelper.success(SUCCESS_MESSAGE);
    }

    /**
     * 成功，携带数据返回
     * @param data 数据
     * @param <T>  数据类型
     * @return {@link ResultModel}
     */
    public static <T> ResultModel<T> success(T data) {
        return ResultHelper.success(SUCCESS_MESSAGE, data);
    }

    /**
     * 错误，携带详细的错误信息
     * @param errorMessage 错误信息
     * @return {@link ResultModel}
     */
    public static ResultModel<Void> error(String errorMessage) {
        return ResultHelper.error(errorMessage);
    }

}
