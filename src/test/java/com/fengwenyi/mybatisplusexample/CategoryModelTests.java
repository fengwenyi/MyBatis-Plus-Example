package com.fengwenyi.mybatisplusexample;

import com.fengwenyi.mybatisplusexample.entity.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * model test
 *
 * <p>
 *     CRUD
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-03-30
 */
@Component
public class CategoryModelTests extends MybatisPlusExampleApplicationTests {

    private CategoryEntity model;

    // 创建数据
    private void create() {
        model = new CategoryEntity().setName("category test data");
        model.insert();
    }

    // 清除数据
    private void clear() {
        model.deleteById();
    }

    @Test
    public void testAdd() {
        model = new CategoryEntity().setName("category test data");
        boolean testResult = model.insert();
        Assert.isTrue(testResult, "data add test failure");


        clear();
    }

    @Test
    public void testDelete() {
        create();

        boolean testResult = model.deleteById();
        Assert.isTrue(testResult, "data delete test failure");
    }

    @Test
    public void testUpdate() {
        create();

        model.setName("category update");
        boolean testResult = model.updateById();
        Assert.isTrue(testResult, "data update test failure");
    }


}
