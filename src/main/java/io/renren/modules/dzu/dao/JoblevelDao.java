package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.JoblevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.form.JobleaveForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工职位等级表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface JoblevelDao extends BaseMapper<JoblevelEntity> {

    List<JobleaveForm> getJobLeaveFormList(@Param("name") String name);
}
