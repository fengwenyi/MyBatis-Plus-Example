package com.fengwenyi.mp3demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengwenyi.javalib.util.ExceptionUtil;
import com.fengwenyi.mp3demo.config.ConstantConfig;
import com.fengwenyi.mp3demo.model.Student;
import com.fengwenyi.mp3demo.dao.StudentDao;
import com.fengwenyi.mp3demo.service.MPStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements MPStudentService {

    @Override
    public boolean addStudent(Student student) {
        ExceptionUtil.notNull(student, "Student must not null.");

        if (queryStudentByIdCardId(student.getIdcardId()) == null)
            return save(student);

        return true;
    }

    @Override
    public Student queryStudentByIdCardId(Long idCardId) {
        ExceptionUtil.notNull(idCardId, "IdCardId must not null");
        QueryWrapper<Student> queryWrapper =
                new QueryWrapper<Student>()
                        .eq(Student.IDCARD_ID, idCardId);
        List<Student> studentList = list(queryWrapper);

        if (studentList == null || studentList.size() == 0)
            return null;

        if (studentList.size() > 1)
            log.error("queryStudentByIdCardId 有多个结果，idCardId={}", idCardId);

        return studentList.get(0);
    }

    // 简单分页查询
    public IPage<Student> queryStudentByPage(Long currentPage) {
        return page(new Page<>(currentPage, ConstantConfig.PAGE_SITE), null);
    }
}
