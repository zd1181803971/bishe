package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.LeaveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.form.LeaveForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 请假表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-22 08:50:11
 */
@Mapper
public interface LeaveDao extends BaseMapper<LeaveEntity> {

    List<LeaveForm> getLeaveFormList(String name);

    List<LeaveEntity> getLeaveListByJob(String jobNumber);
}
