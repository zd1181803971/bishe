package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.service.EmployeeService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EmployeeEntity employee){
		employeeService.save(employee);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EmployeeEntity employee){
		employeeService.updateById(employee);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		employeeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
