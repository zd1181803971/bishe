package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.SaleChancePlanEntity;

import java.util.Map;

/**
 * 营销管理计划表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
public interface SaleChancePlanService extends IService<SaleChancePlanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

