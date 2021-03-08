package com.fengwenyi.mybatisplusexample;

import com.fengwenyi.mybatisplusexample.entity.CategoryEntity;
import com.fengwenyi.mybatisplusexample.repository.MPCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author Erwin Feng
 * @since 2021-03-08
 */
@Component
public class CategoryRepositoryTests extends MybatisPlusExampleApplicationTests {

    @Autowired
    private MPCategoryRepository mpCategoryRepository;

    @Test
    public void testAdd() {
        CategoryEntity categoryEntity = new CategoryEntity().setName("testAddCategory");
        boolean categorySaveResult = mpCategoryRepository.save(categoryEntity);
        Assert.isTrue(categorySaveResult, "商品类别保存失败");
        boolean categoryDeleteResult = mpCategoryRepository.removeById(categoryEntity.getId());
        Assert.isTrue(categoryDeleteResult, "商品类别删除失败");

        boolean insert = categoryEntity.insert();
        boolean b = categoryEntity.deleteById();
    }

}
