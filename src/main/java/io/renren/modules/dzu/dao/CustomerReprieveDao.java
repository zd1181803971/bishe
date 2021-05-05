package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.CustomerReprieveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户流失暂缓表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@Mapper
public interface CustomerReprieveDao extends BaseMapper<CustomerReprieveEntity> {
	
}
