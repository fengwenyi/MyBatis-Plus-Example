package com.fengwenyi.mp3demo;

import com.fengwenyi.mp3demo.dao.CityDao;
import com.fengwenyi.mp3demo.service.MPCityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mp3DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MPCityService mpCityService;

    @Autowired
    private CityDao cityDao;

    public void test() {
        /*//----------------------service start
        mpCityService.save();
        mpCityService.update();
        mpCityService.updateById();
        mpCityService.remove();
        mpCityService.removeById();
        //----------------------service end

        //----------------------mapper start
        cityDao.insert();
        cityDao.update();
        cityDao.updateById();
        cityDao.delete();
        cityDao.deleteById()
        //----------------------mapper end

        // select

        mpCityService.list();
        mpCityService.getById();
        mpCityService.getObj();
        mpCityService.getOne();
        mpCityService.getMap();
        mpCityService.page();
        mpCityService.pageMaps();*/
    }

}
