package com.fengwenyi.mp3demo.business.impl;

import com.fengwenyi.javalib.util.ExceptionUtil;
import com.fengwenyi.mp3demo.business.AppBusiness;
import com.fengwenyi.mp3demo.model.City;
import com.fengwenyi.mp3demo.model.Idcard;
import com.fengwenyi.mp3demo.model.Student;
import com.fengwenyi.mp3demo.service.MPCityService;
import com.fengwenyi.mp3demo.service.MPIdcardService;
import com.fengwenyi.mp3demo.service.MPStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 数据库表关联逻辑处理接口实现
 *
 * @author Wenyi Feng
 * @since 2018-09-01
 */
@Service
@Transactional
@Slf4j
public class AppBusinessImpl implements AppBusiness {

    @Resource
    private MPCityService mpCityService;

    @Resource
    private MPIdcardService mpIdcardService;

    @Resource
    private MPStudentService mpStudentService;

    @Override
    public boolean addStudent(Student student, City city, Idcard idcard) {
        ExceptionUtil.notNull(student, "Student must not null");
        ExceptionUtil.notNull(city, "City must not null");
        ExceptionUtil.notNull(idcard, "IdCard must not null");

        boolean rsAddCity = mpCityService.addCity(city);
        if (rsAddCity) {
            String cityName = city.getName();
            city = mpCityService.queryCityByName(cityName);
            if (city != null) {
                boolean rsAddIdCard = mpIdcardService.addIdCard(idcard);
                if (rsAddIdCard) {
                    String idCardCode = idcard.getCode();
                    idcard = mpIdcardService.queryIdCardByCode(idCardCode);
                    if (idcard != null) {
                        student.setCityId(city.getId()).setIdcardId(idcard.getId());
                        return mpStudentService.addStudent(student);
                    } else
                        log.error("queryIdCardByCode 查询失败，idCardCode={}", idCardCode);
                } else
                    log.error("增加IdCard失败：{}", idcard);
            } else
                log.error("queryCityByName 查询失败，name={}", cityName);
        } else
            log.error("增加City失败：{}", city);

        return false;
    }
}
