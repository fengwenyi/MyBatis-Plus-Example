package com.fengwenyi.mybatisplusexample.repository.impl;

import com.fengwenyi.mybatisplusexample.entity.CategoryEntity;
import com.fengwenyi.mybatisplusexample.mapper.ICategoryMapper;
import com.fengwenyi.mybatisplusexample.repository.MPCategoryRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-03-07
 */
@Service
public class CategoryRepositoryImpl extends ServiceImpl<ICategoryMapper, CategoryEntity> implements MPCategoryRepository {

}
