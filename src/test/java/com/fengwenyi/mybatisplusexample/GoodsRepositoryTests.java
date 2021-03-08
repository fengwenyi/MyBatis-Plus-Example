package com.fengwenyi.mybatisplusexample;

import com.fengwenyi.mybatisplusexample.entity.GoodsEntity;
import com.fengwenyi.mybatisplusexample.repository.MPGoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author Erwin Feng
 * @since 2021-03-08
 */
@Component
public class GoodsRepositoryTests extends MybatisPlusExampleApplicationTests {

    @Autowired
    private MPGoodsRepository mpGoodsRepository;

    @Test
    public void testAdd() {
        GoodsEntity goodsEntity = new GoodsEntity()
                ;
        Assert.isTrue(mpGoodsRepository.save(goodsEntity), "save fail");
        Assert.isTrue(mpGoodsRepository.removeById(goodsEntity), "deleteById fail");
    }

}
