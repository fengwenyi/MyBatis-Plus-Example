package com.fengwenyi.learnmybatisplus.business;

import com.fengwenyi.learnmybatisplus.model.City;
import com.fengwenyi.learnmybatisplus.model.Idcard;
import com.fengwenyi.learnmybatisplus.model.Student;

/**
 * 数据库表关联逻辑处理接口
 *
 * @author Wenyi Feng
 * @since 2018-09-01
 */
public interface AppBusiness {

    boolean addStudent(Student student, City city, Idcard idcard);

}
