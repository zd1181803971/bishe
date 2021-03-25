package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.DepartmentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.form.DeptForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface DepartmentDao extends BaseMapper<DepartmentEntity> {

    List<DeptForm> getDeptFormList(@Param("deptName") String deptName);
}
