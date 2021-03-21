package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.PositionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工职位表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface PositionDao extends BaseMapper<PositionEntity> {
	
}
