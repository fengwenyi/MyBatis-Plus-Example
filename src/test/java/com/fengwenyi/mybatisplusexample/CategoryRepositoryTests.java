package com.fengwenyi.mybatisplusexample;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengwenyi.mybatisplusexample.entity.CategoryEntity;
import com.fengwenyi.mybatisplusexample.repository.MPCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 *
 * MPCategoryRepository test
 *
 * <p>
 *     CRUD
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-03-08
 */
@Component
@Slf4j
public class CategoryRepositoryTests extends MybatisPlusExampleApplicationTests {

    @Autowired
    private MPCategoryRepository mpCategoryRepository;

    private CategoryEntity entity;

    // 创建数据
    private void create() {
        entity = new CategoryEntity().setName("category test data");
        mpCategoryRepository.save(entity);
    }

    // 清除数据
    private void clear() {
        mpCategoryRepository.removeById(entity);
    }

    @Test
    public void testAdd() {
        entity = new CategoryEntity().setName("category test data");
        boolean testResult = mpCategoryRepository.save(entity);
        Assert.isTrue(testResult, "data add test failure");


        clear();
    }

    @Test
    public void testDelete() {
        create();


        boolean testResult = mpCategoryRepository.removeById(entity.getId());
        Assert.isTrue(testResult, "data delete test failure");
    }

    @Test
    public void testDeleteByWrapper() {
        create();


        LambdaQueryWrapper<CategoryEntity> queryWrapper = new LambdaQueryWrapper<CategoryEntity>()
                .eq(CategoryEntity::getName, entity.getName())
                ;

        boolean testResult = mpCategoryRepository.remove(queryWrapper);
        Assert.isTrue(testResult, "data delete by wrapper test failure");
    }

    @Test
    public void testUpdate() {
        create();

        entity.setName("category update");
        boolean testResult = mpCategoryRepository.updateById(entity);
        Assert.isTrue(testResult, "data update test failure");

        clear();
    }

    @Test
    public void testQuery() {
        create();

        // 根据主键ID查询
        mpCategoryRepository.getById(entity.getId());


        // 查询所有
        List<CategoryEntity> list = mpCategoryRepository.list();

        // 添加查询
        LambdaQueryWrapper<CategoryEntity> queryWrapper = new LambdaQueryWrapper<CategoryEntity>()
                .eq(CategoryEntity::getName, entity.getName())
                ;
        mpCategoryRepository.list(queryWrapper);

        // 分页查询
        int currentPage = 1;
        int pageSize = 10;
        Page<CategoryEntity> categoryPage = mpCategoryRepository.page(new Page<>(currentPage, pageSize), queryWrapper);

        long current = categoryPage.getCurrent();
        long size = categoryPage.getSize();
        long pages = categoryPage.getPages();
        List<CategoryEntity> categoryList = categoryPage.getRecords();
        long total = categoryPage.getTotal();


        clear();
    }

}
