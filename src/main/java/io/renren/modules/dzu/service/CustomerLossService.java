package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.CustomerLossEntity;

import java.util.Map;

/**
 * 客户流失表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
public interface CustomerLossService extends IService<CustomerLossEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

