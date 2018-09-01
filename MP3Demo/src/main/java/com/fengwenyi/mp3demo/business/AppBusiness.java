package com.fengwenyi.mp3demo.business;

import com.fengwenyi.mp3demo.model.City;
import com.fengwenyi.mp3demo.model.Idcard;
import com.fengwenyi.mp3demo.model.Student;

/**
 * 数据库表关联逻辑处理接口
 *
 * @author Wenyi Feng
 * @since 2018-09-01
 */
public interface AppBusiness {

    boolean addStudent(Student student, City city, Idcard idcard);

}
