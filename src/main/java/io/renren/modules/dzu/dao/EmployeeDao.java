package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.EmployeeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface EmployeeDao extends BaseMapper<EmployeeEntity> {
	
}
