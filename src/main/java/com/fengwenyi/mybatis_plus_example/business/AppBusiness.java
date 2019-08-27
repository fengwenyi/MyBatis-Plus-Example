package com.fengwenyi.mybatis_plus_example.business;

import com.fengwenyi.mybatis_plus_example.model.City;
import com.fengwenyi.mybatis_plus_example.model.Idcard;
import com.fengwenyi.mybatis_plus_example.model.Student;

/**
 * 数据库表关联逻辑处理接口
 *
 * @author Wenyi Feng
 * @since 2018-09-01
 */
public interface AppBusiness {

    boolean addStudent(Student student, City city, Idcard idcard);

}
