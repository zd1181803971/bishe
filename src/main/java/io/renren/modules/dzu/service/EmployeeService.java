package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.dto.DeptAndEmpCountDto;
import io.renren.modules.dzu.entity.dto.EmpIdNameDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
public interface EmployeeService extends IService<EmployeeEntity> {


    PageUtils queryPage(Map<String, Object> params);

    EmployeeEntity getEmployeeByjobNumber(String jobnumber);

    List<EmployeeEntity> getEmpByIds(Map<String, Object> map);

    HashMap<String, Integer> getChartLineData();

    PageUtils getEmpFormList(Map<String, Object> map);

    EmpIdNameDto getIdNameByJob(String jobNumber);

    List<DeptAndEmpCountDto> getDeptAndEmpCount();

    /**
     * 添加员工 添加默认薪资 默认登录账户
     * @param employee
     * @return
     */
    R saveEmpWithSalaryAndSysUser(EmployeeEntity employee);

    /**
     * 删除员工同时删除薪资记录和账户和请假记录
     * @param ids
     * @return
     */
    R removeByIdsWithSalaryAndSysUerAndLeaves(Long[] ids);

    /**
     * 员工若修改邮箱和手机  账户也随着修改
     * @param employee
     * @return
     */
    R updateWithEmailAndPhone(EmployeeEntity employee);
}

