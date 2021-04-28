package io.renren.modules.dzu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.EmployeeecEntity;
import io.renren.modules.dzu.entity.dto.EmpClockDto;
import io.renren.modules.dzu.entity.form.EmployeeecForm;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工奖罚表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface EmployeeecDao extends BaseMapper<EmployeeecEntity> {

    List<EmpClockDto> getEmpClockData();


    List<EmployeeecForm> getEmployeeecForm(String name, LocalDate localDate);
}
