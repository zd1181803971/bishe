package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.LeaveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 请假表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-22 08:50:11
 */
@Mapper
public interface LeaveDao extends BaseMapper<LeaveEntity> {
	
}
