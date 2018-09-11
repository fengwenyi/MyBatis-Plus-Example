package com.fengwenyi.mp3demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengwenyi.mp3demo.model.Student;

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
