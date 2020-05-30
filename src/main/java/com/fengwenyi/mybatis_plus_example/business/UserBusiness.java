package com.fengwenyi.mybatis_plus_example.business;

import com.fengwenyi.mybatis_plus_example.vo.response.UserResponseVo;

import java.util.List;

/**
 * 用户业务层（接口）
 * @author Erwin Feng
 * @since 2020/5/30
 */
public interface UserBusiness {

    /**
     * 查询用户列表
     * @return 返回用户列表
     */
    List<UserResponseVo> users();

}
