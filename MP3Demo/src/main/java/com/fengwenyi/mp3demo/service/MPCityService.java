package com.fengwenyi.mp3demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengwenyi.mp3demo.model.City;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
public interface MPCityService extends IService<City> {

    List<City> queryCityAll();

    boolean addCity(City city);

    City queryCityByName(String name);

}
