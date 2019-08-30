package com.fengwenyi.mybatis_plus_example.service;

import com.fengwenyi.mybatis_plus_example.MybatisPlusExampleApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @author Erwin Feng
 * @since 2019/8/30 11:47
 */
@Component
public class MPStudentServiceTest extends MybatisPlusExampleApplicationTests {

    @Autowired
    private MPStudentService mpStudentService;

    @Test
    public void findByNameAndAge() {
        mpStudentService.findByNameAndAge("张三", null);
        mpStudentService.findByNameAndAge(null, 18);
        mpStudentService.findByNameAndAge("张三", 18);
    }
}