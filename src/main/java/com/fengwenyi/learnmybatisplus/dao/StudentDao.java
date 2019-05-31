package com.fengwenyi.learnmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengwenyi.learnmybatisplus.model.Student;

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
