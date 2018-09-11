package com.fengwenyi.mp3demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fengwenyi.javalib.result.Result;
import com.fengwenyi.javalib.util.StringUtil;
import com.fengwenyi.mp3demo.business.AppBusiness;
import com.fengwenyi.mp3demo.enums.GenderEnum;
import com.fengwenyi.mp3demo.model.City;
import com.fengwenyi.mp3demo.model.Idcard;
import com.fengwenyi.mp3demo.model.Student;
import com.fengwenyi.mp3demo.service.MPCityService;
import com.fengwenyi.mp3demo.service.MPStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试
 *
 * @author Wenyi Feng
 * @since 2018-09-01
 */
@RestController
@RequestMapping(value = "/app", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "App 测试示例")
public class AppController {

    @Autowired
    private MPCityService mpCityService;

    @Autowired
    private AppBusiness appBusiness;

    @Autowired
    private MPStudentService mpStudentService;

    // 查询所有城市
    @GetMapping("/queryCityAll")
    public List<City> queryCityAll() {
        return mpCityService.queryCityAll();
    }


    // 添加城市
    @PostMapping("/addCity")
    public boolean addCity(String name) {
        if (StringUtil.isEmpty(name))
            return false;
        return mpCityService.addCity(new City().setName(name));
    }

    // 添加学生
    @PostMapping("/addStudent")
    public boolean addStudent(String name, Integer age, String gender, String info, String idCardCode, String cityName) {

        // 检验参数
        if (StringUtil.isEmpty(name)
                || age == null
                || StringUtil.isEmpty(gender)
                || StringUtil.isEmpty(info)
                || StringUtil.isEmpty(idCardCode)
                || StringUtil.isEmpty(cityName))
            return false;

        // 获取GenderEnum
        GenderEnum genderEnum = GenderEnum.getEnumByDesc(gender);

        // student
        Student student = new Student()
                .setName(name)
                .setAge(age)
                .setGender(genderEnum)
                .setInfo(info);

        // city
        City city = new City().setName(cityName);

        // idCard
        Idcard idcard = new Idcard().setCode(idCardCode);

        // service
        return appBusiness.addStudent(student, city, idcard);
    }

    // 分页查询学生
    @GetMapping("/queryStudentByPage/{currentPage}")
    public IPage<Student> queryStudentByPage(@PathVariable("currentPage") Long currentPage) {
        if (currentPage == null)
            return null;
        return mpStudentService.queryStudentByPage(currentPage);
    }
}
