package com.fengwenyi.mp3demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fengwenyi.mp3demo.model.Student;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
public interface MPStudentService extends IService<Student> {

    boolean addStudent(Student student);

    Student queryStudentByIdCardId(Long idCardId);

    IPage<Student> queryStudentByPage(Long currentPage);

}
