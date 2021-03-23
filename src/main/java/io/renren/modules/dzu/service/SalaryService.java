package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.SalaryEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工工资表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:17
 */
public interface SalaryService extends IService<SalaryEntity> {

    PageUtils queryPage(Map<String, Object> params);


    SalaryEntity getSalaryByid(Long eid);

    HashMap<String, Integer> getCharBarData();

    PageUtils getSalaryFormList(Map<String, Object> params);
}

