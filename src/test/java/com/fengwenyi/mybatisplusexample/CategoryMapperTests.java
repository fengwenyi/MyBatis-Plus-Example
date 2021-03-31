package com.fengwenyi.mybatisplusexample;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengwenyi.mybatisplusexample.entity.CategoryEntity;
import com.fengwenyi.mybatisplusexample.mapper.ICategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * MyBatis Mapper CRUD
 *
 * @author Erwin Feng
 * @since 2021-04-01
 */
@Component
@Slf4j
public class CategoryMapperTests extends MybatisPlusExampleApplicationTests {

    private CategoryEntity entity;

    @Resource
    private ICategoryMapper categoryMapper;

    // 创建数据
    private void create() {
        entity = new CategoryEntity().setName("category test data");
        categoryMapper.insert(entity);
    }

    // 清除数据
    private void clear() {
        categoryMapper.deleteById(entity.getId());
    }

    @Test
    public void testAdd() {
        entity = new CategoryEntity().setName("category test data");
        int resultNum = categoryMapper.insert(entity);
        Assert.isTrue(resultNum == 1, "data add test failure");


        clear();
    }

    @Test
    public void testDelete() {
        create();

        int resultNum = categoryMapper.deleteById(entity.getId());
        Assert.isTrue(resultNum == 1, "data delete test failure");
    }

    @Test
    public void testUpdate() {
        create();

        entity.setName("category update");
        int resultNum = categoryMapper.updateById(entity);
        Assert.isTrue(resultNum == 1, "data update test failure");

        clear();
    }

    @Test
    public void testQuery() {
        create();

        List<CategoryEntity> categoryEntityList = categoryMapper.selectList(new QueryWrapper<>());
        for (CategoryEntity entity : categoryEntityList) {
            log.info(entity.toString());
        }

        clear();
    }

}
