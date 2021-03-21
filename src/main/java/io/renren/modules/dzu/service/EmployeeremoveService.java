package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.EmployeeremoveEntity;

import java.util.Map;

/**
 * 员工部门调动表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
public interface EmployeeremoveService extends IService<EmployeeremoveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

