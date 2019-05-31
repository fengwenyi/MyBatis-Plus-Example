package com.fengwenyi.learnmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengwenyi.javalib.util.Console;
import com.fengwenyi.javalib.util.ExceptionUtil;
import com.fengwenyi.learnmybatisplus.config.ConstantConfig;
import com.fengwenyi.learnmybatisplus.model.Student;
import com.fengwenyi.learnmybatisplus.dao.StudentDao;
import com.fengwenyi.learnmybatisplus.service.MPStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    //--------------------------------------------------test start

    // 通过名字进行筛选
    @Override
    public void test1() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Student::getName, "冯文议");
//        queryWrapper.lambda().like(Student::getName, "文");
        List<Student> studentList = list(queryWrapper);
        for (Student student : studentList)
            Console.info(new Gson().toJson(student));
    }

    @Override
    public void test2() {

        IPage<Student> page = page(
                new Page<>(1, 2),
                null);

        Console.info(new Gson().toJson(page));

    }

    @Override
    public void test3() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Student::getName, "冯文议")
//                .eq(Student::getAge, 26)
                .eq(Student::getAge, 25);
        List<Student> studentList = list(queryWrapper);
        for (Student student : studentList)
            Console.info(new Gson().toJson(student));
    }

    @Override
    public void test4() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .and(obj ->
                        obj.eq(Student::getName, "冯文议")
                            .eq(Student::getAge, 26));

        List<Student> studentList = list(queryWrapper);
        for (Student student : studentList)
            Console.info(new Gson().toJson(student));
    }

    @Override
    public void test5() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .or(obj1 -> obj1.eq(Student::getName, "冯文议"))
                .or(obj2 -> obj2.eq(Student::getName, "1"));
        List<Student> studentList = list(queryWrapper);
        for (Student student : studentList)
            Console.info(new Gson().toJson(student));
    }

    @Override
    public void test6() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Student::getName, "冯文议")
                .or()
                .eq(Student::getName, "1");
        List<Student> studentList = list(queryWrapper);
        for (Student student : studentList)
            Console.info(new Gson().toJson(student));
    }

    @Resource
    StudentDao studentDao;

    @Override
    public void test7() {
        List<Student> studentList = studentDao.selectAll();
        for (Student student : studentList)
            Console.info(new Gson().toJson(student));
    }

    @Override
    public List<Student> findAll() {
        return list(null);
    }

    @Override
    public List<Student> findList() {
        return list(null);
    }

    @Override
    public Student findOne() {
        return getOne(null);
    }

    @Override
    public Student findById(Long id) {
        ExceptionUtil.notNull(id, "id must not null.");
        return getById(id);
    }

    //--------------------------------------------------test end
}
