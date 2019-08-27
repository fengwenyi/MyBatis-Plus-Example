package com.fengwenyi.mybatis_plus_example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengwenyi.javalib.util.ExceptionUtil;
import com.fengwenyi.mybatis_plus_example.model.Idcard;
import com.fengwenyi.mybatis_plus_example.dao.IdcardDao;
import com.fengwenyi.mybatis_plus_example.service.MPIdcardService;
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
public class IdcardServiceImpl extends ServiceImpl<IdcardDao, Idcard> implements MPIdcardService {

    @Override
    public boolean addIdCard(Idcard idcard) {
        ExceptionUtil.notNull(idcard, "IdCard must not null");
        if (queryIdCardByCode(idcard.getCode()) == null)
            return save(idcard);
        return true;
    }

    @Override
    public Idcard queryIdCardByCode(String code) {
        ExceptionUtil.notNull(code, "IdCardCode must not null");
        QueryWrapper<Idcard> queryWrapper =
                new QueryWrapper<Idcard>()
                        .eq(Idcard.CODE, code);
        List<Idcard> idCardList = list(queryWrapper);

        if (idCardList == null || idCardList.size() == 0)
            return null;

        if (idCardList.size() > 1)
            log.error("queryIdCardByCode有多个返回结果，code={}", code);

        return idCardList.get(0);
    }
}
