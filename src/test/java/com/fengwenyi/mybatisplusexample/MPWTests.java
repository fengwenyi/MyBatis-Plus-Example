package com.fengwenyi.mybatisplusexample;

import com.baomidou.mybatisplus.core.toolkit.AES;
import com.fengwenyi.javalib.util.PrintUtils;
import org.junit.jupiter.api.Test;

/**
 * @author Erwin Feng
 * @since 2021-03-31
 */
public class MPWTests {

    @Test
    public void test() {

        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        PrintUtils.info(randomKey);

        String prefix = "mpw:";

        // 随机密钥加密
        String url = "jdbc:p6spy:mysql://192.168.16.128:3306/mybatis-plus-example";
        String result =prefix + AES.encrypt(url, randomKey);
        PrintUtils.info(result);

        String username = "root";
        result =prefix + AES.encrypt(username, randomKey);
        PrintUtils.info(result);

        String password = "123456";
        result =prefix + AES.encrypt(password, randomKey);
        PrintUtils.info(result);

/*
2021-03-31 00:57:49.494 INFO com.fengwenyi.mybatisplusexample.MPWTests#test : ba8a2cea8df4929f
2021-03-31 00:57:49.871 INFO com.fengwenyi.mybatisplusexample.MPWTests#test : mpw:pBZqJb+r/StFGyRopKJyhZN8dvstxaXxubewECBMWM3e7XK+719AUXlC1y1Cu14i1MwqEdiJbBa+sEwFzyWEgA==
2021-03-31 00:57:49.871 INFO com.fengwenyi.mybatisplusexample.MPWTests#test : mpw:hjR022j+cjKFE+35FLTQgg==
2021-03-31 00:57:49.871 INFO com.fengwenyi.mybatisplusexample.MPWTests#test : mpw:kzLGIBmi4hT+dPmqnXLAIw==
 */

    }

}
