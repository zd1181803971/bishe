package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.dzu.entity.NationEntity;

import java.util.Map;

/**
 * 员工民族表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
public interface NationService extends IService<NationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getNationForm(Map<String, Object> params);
}

