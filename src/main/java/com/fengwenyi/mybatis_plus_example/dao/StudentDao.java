package com.fengwenyi.mybatis_plus_example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengwenyi.mybatis_plus_example.model.Student;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
public interface StudentDao extends BaseMapper<Student> {

    List<Student> selectAll();

}
