package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.SaleChanceEntity;

import java.util.Map;

/**
 * 营销机会表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
public interface SaleChanceService extends IService<SaleChanceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getListForm(Map<String, Object> params);

    PageUtils getListFormByAssignEmp(Map<String, Object> params);
}

