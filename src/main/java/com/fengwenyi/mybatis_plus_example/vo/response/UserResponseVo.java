package com.fengwenyi.mybatis_plus_example.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户响应VO
 * @author Erwin Feng
 * @since 2020/5/30
 */
@Data
@Accessors(chain = true)
public class UserResponseVo {

    /** ID */
    private String id;

    /** 用户名 */
    private String username;

    /** 昵称 */
    private String nickname;

    /** 性别 */
    private Integer sex;

    /** 创建时间，时间戳（毫秒） */
    private String createTime;

}
