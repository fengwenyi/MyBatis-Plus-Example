package com.fengwenyi.mybatis_plus_example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengwenyi.mybatis_plus_example.model.Idcard;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
public interface MPIdcardService extends IService<Idcard> {

    boolean addIdCard(Idcard idcard);

    Idcard queryIdCardByCode(String code);

}
