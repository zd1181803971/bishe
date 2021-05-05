package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.CustomerReprieveEntity;

import java.util.Map;

/**
 * 客户流失暂缓表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
public interface CustomerReprieveService extends IService<CustomerReprieveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

