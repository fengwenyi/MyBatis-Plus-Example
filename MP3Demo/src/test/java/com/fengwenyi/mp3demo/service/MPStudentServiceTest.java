package com.fengwenyi.mp3demo.service;

import com.fengwenyi.mp3demo.Mp3DemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @author Wenyi Feng
 * @since 2018-09-11
 */
@Component
public class MPStudentServiceTest extends Mp3DemoApplicationTests {

    @Autowired
    private MPStudentService mpStudentService;

    @Test
    public void test1() {

        mpStudentService.test1();

    }

    @Test
    public void test2() {
        mpStudentService.test2();
    }

    @Test
    public void test3() {
        mpStudentService.test3();
    }

    @Test
    public void test4() {
        mpStudentService.test4();
    }

    @Test
    public void test5() {
        mpStudentService.test5();
    }

    @Test
    public void test6() {
        mpStudentService.test6();
    }

    @Test
    public void test7() {
        mpStudentService.test7();
    }

    @Test
    public void test8() {
//        mpStudentService.find
    }
}