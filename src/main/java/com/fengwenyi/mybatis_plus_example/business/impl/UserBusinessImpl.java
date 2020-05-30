package com.fengwenyi.mybatis_plus_example.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fengwenyi.javalib.util.DateTimeUtils;
import com.fengwenyi.mybatis_plus_example.business.UserBusiness;
import com.fengwenyi.mybatis_plus_example.db.entity.UserEntity;
import com.fengwenyi.mybatis_plus_example.db.repository.UserRepository;
import com.fengwenyi.mybatis_plus_example.vo.response.UserResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户业务层（实现）
 *
 * @author Erwin Feng
 * @since 2020/5/30
 */
@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseVo> users() {
        List<UserEntity> list = userRepository.list(
                new LambdaQueryWrapper<UserEntity>()
                        .eq(UserEntity::getReleaseStatus, true)
                        .orderByDesc(UserEntity::getCreateTime));
        return list
                .stream()
                .map(userEntity ->
                        new UserResponseVo()
                                .setId(userEntity.getId() + "")
                                .setUsername(userEntity.getUsername())
                                .setNickname(userEntity.getNickname())
                                .setSex(userEntity.getSex())
                                .setCreateTime(DateTimeUtils.toMillisecond(userEntity.getCreateTime()) + ""))
                .collect(Collectors.toList());
    }
}
