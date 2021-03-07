package com.fengwenyi.mybatisplusexample.repository.impl;

import com.fengwenyi.mybatisplusexample.entity.GoodsEntity;
import com.fengwenyi.mybatisplusexample.mapper.IGoodsMapper;
import com.fengwenyi.mybatisplusexample.repository.MPGoodsRepository;
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
public class GoodsRepositoryImpl extends ServiceImpl<IGoodsMapper, GoodsEntity> implements MPGoodsRepository {

}
