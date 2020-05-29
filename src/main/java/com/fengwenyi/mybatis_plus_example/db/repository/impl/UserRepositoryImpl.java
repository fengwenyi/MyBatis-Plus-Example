package com.fengwenyi.mybatis_plus_example.db.repository.impl;

import com.fengwenyi.mybatis_plus_example.db.entry.UserEntry;
import com.fengwenyi.mybatis_plus_example.db.dao.UserDao;
import com.fengwenyi.mybatis_plus_example.db.repository.UserRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2020-05-29
 */
@Service
public class UserRepositoryImpl extends ServiceImpl<UserDao, UserEntry> implements UserRepository {

}
