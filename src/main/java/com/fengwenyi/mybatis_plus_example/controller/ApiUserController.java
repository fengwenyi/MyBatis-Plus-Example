package com.fengwenyi.mybatis_plus_example.controller;

import com.fengwenyi.api_result.model.ResultModel;
import com.fengwenyi.mybatis_plus_example.business.UserBusiness;
import com.fengwenyi.mybatis_plus_example.result.ResultUtils;
import com.fengwenyi.mybatis_plus_example.vo.response.UserResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户接口
 * @author Erwin Feng
 * @since 2020/5/30
 */
@RestController
@RequestMapping(value = "/api/user",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ApiUserController {

    @Autowired
    private UserBusiness userBusiness;

    /**
     * 查询用户列表
     * @return 返回用户列表 {@link UserResponseVo}
     */
    @GetMapping
    public ResultModel<List<UserResponseVo>> users() {
        return ResultUtils.success(userBusiness.users());
    }

}
