package com.fengwenyi.mp3demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengwenyi.javalib.util.ExceptionUtil;
import com.fengwenyi.mp3demo.model.City;
import com.fengwenyi.mp3demo.dao.CityDao;
import com.fengwenyi.mp3demo.service.MPCityService;
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
public class MPCityServiceImpl extends ServiceImpl<CityDao, City> implements MPCityService {

    @Override
    public List<City> queryCityAll() {
        return list(null);
    }

    @Override
    public boolean addCity(City city) {

        ExceptionUtil.notNull(city, "City must not null");

        String name = city.getName();

        if (queryCityByName(name) == null)
            return save(city);

        // 数据库已经存在
        return true;
    }

    @Override
    public City queryCityByName(String name) {

        ExceptionUtil.notNull(name, "City name must not null");

        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(City.NAME, name);

        List<City> cityList = list(queryWrapper);

        if (cityList == null || cityList.size() == 0)
            return null;

        if (cityList.size() > 1)
            log.error("queryCityByName结果有多个，name={}", name);

        return cityList.get(0);
    }
}
