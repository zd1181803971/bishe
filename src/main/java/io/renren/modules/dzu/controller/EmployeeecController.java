package io.renren.modules.dzu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.dzu.entity.EmployeeecEntity;
import io.renren.modules.dzu.service.EmployeeecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/**
 * 员工报工表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/employeeec")
public class EmployeeecController {
    @Autowired
    private EmployeeecService employeeecService;


    /**
     * 今日报工表单
     * @param params
     * @return
     */
    @GetMapping("/getEmployeeecFormListByNow")
    public R getEmployeeecFormByNow(@RequestParam Map<String, Object> params){
        params.put("empTime", LocalDate.now().toString());
        PageUtils page  = employeeecService.getemployeeecForm(params);
        return R.ok().put("page", page);
    }

    /**
     * 报工表单
     * @param params
     * @return
     */
    @GetMapping("/getEmployeeecFormList")
    public R getEmployeeecForm(@RequestParam Map<String, Object> params){
        PageUtils page  = employeeecService.getemployeeecForm(params);
        return R.ok().put("page", page);
    }
    /**
     * 通过工号获取报工记录
     * @param jobnumber
     * @return
     */
    @GetMapping("/getEmpClockByEid/{jobnumber}")
    public R getEmpClockByEid(@PathVariable("jobnumber") String jobnumber ){
        EmployeeecEntity entity = employeeecService.getEmpClockByEid(jobnumber);
        return R.ok().put("entity",entity);
    }

    // 所有员工今日报工情况
    @GetMapping("/getEmpClock")
    public R getEmpClock(){
        HashMap<String, Integer> empClock = employeeecService.getEmpClock();
        return R.ok().put("list",empClock);
    }

    /**
     * 获取当天的打卡记录
     */
    @RequestMapping("/getCurrentData")
    public R getDataByCurrentTime(@RequestParam Map<String, Object> params){
        PageUtils page = employeeecService.queryPage2(params);
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeecService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EmployeeecEntity employeeec = employeeecService.getById(id);

        return R.ok().put("employeeec", employeeec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EmployeeecEntity employeeec){
        ValidatorUtils.validateEntity(employeeec, AddGroup.class);
        int count = employeeecService.count(new QueryWrapper<EmployeeecEntity>().eq("eid", employeeec.getEid()).eq("ecDate", employeeec.getEcdate()));
        if (count>=1){
            return R.error("你今天已经打卡了");
        }else {
            employeeecService.save(employeeec);
            return R.ok();
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EmployeeecEntity employeeec){
        ValidatorUtils.validateEntity(employeeec, UpdateGroup.class);

        employeeecService.updateById(employeeec);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		employeeecService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
