package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.EmployeeecEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工奖罚表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
public interface EmployeeecService extends IService<EmployeeecEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage2(Map<String, Object> params);

    HashMap<String, Integer> getEmpClock();

    EmployeeecEntity getEmpClockByEid(String jobnumber);

    PageUtils getemployeeecForm(Map<String, Object> params);
}

