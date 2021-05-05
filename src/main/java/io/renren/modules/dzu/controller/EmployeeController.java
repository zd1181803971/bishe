package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.dto.DeptAndEmpCountDto;
import io.renren.modules.dzu.entity.dto.EmpIdNameDto;
import io.renren.modules.dzu.entity.form.SelectForm;
import io.renren.modules.dzu.service.EmployeeService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 员工表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/employee")
public class EmployeeController extends AbstractController {

    @Autowired
    private EmployeeService employeeService;


//    选择器Select  获取所有员工姓名
        @GetMapping("/getEmpNameList")
    public R getEmpNameList(){
        List<EmployeeEntity> list = employeeService.list(null);
        ArrayList<SelectForm> selectForms = new ArrayList<>();
        for (EmployeeEntity entity: list){
            selectForms.add(new SelectForm(entity.getJobnumber(),entity.getId()));
        }
        return R.ok().put("list",selectForms);
    }


// 获取部门以及部门下员工人数
    @GetMapping("/getDeptAndEmpCount")
    public R getDeptAndEmpCount(){
        List<DeptAndEmpCountDto> deptAndEmpCount = employeeService.getDeptAndEmpCount();
        return R.ok().put("deptAndEmpCount",deptAndEmpCount);
    }

//    通过工号获取员工id和员工姓名
    @GetMapping("/getIdNameByjob/{jobNumber}")
    public R getIdNameByJob(@PathVariable("jobNumber") String jobNumber){
        EmpIdNameDto empIdNameDto =  employeeService.getIdNameByJob(jobNumber);
        if (empIdNameDto != null){
            return R.ok().put("empIdNameDto",empIdNameDto);
        }else {
            return R.error("没有这个员工工号");
        }
    }
//    获取员工信息表单
    @GetMapping("/getEmpFormList")
    public R getEmpFormList(@RequestParam Map<String, Object> map){
        PageUtils page = employeeService.getEmpFormList(map);
        return R.ok().put("page",page);
    }


// 通过学校分类 得到员工人数
    @GetMapping("/chartLine")
    public R getChartLineData(){
        HashMap<String,Integer> map = employeeService.getChartLineData();
        return R.ok().put("data",map);
    }


//    通过ids 获取员工信息
    @GetMapping("/getEmpsByIds")
    public R getEmpByIds(@RequestParam Map<String, Object> map){
        List<EmployeeEntity> lists = employeeService.getEmpByIds(map);
        return R.ok().put("employeeList",lists);
    }

    //通过工号获取用户信息
    @GetMapping("/jobNumber/{jobnumber}")
    public R getEmployeeByjobNumber(@PathVariable("jobnumber") String jobnumber){
        EmployeeEntity employee =  employeeService.getEmployeeByjobNumber(jobnumber);
        return R.ok().put("employee", employee);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeService.queryPage(params);
        return R.ok().put("page", page);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EmployeeEntity employee = employeeService.getById(id);

        return R.ok().put("employee", employee);
    }


    /**
     * 新增员工时，同时增加默认工资 3210块钱，增加系统账号，默认密码123456 默认启用
     */
    @RequestMapping("/save")
    public R save(@RequestBody EmployeeEntity employee){
        ValidatorUtils.validateEntity(employee, AddGroup.class);

        return employeeService.saveEmpWithSalaryAndSysUser(employee);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EmployeeEntity employee){
        ValidatorUtils.validateEntity(employee, UpdateGroup.class);
        return employeeService.updateWithEmailAndPhone(employee);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        return employeeService.removeByIdsWithSalaryAndSysUerAndLeaves(ids);
    }

}
