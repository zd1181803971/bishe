package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.SalaryEntity;
import io.renren.modules.dzu.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/**
 * 员工工资表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:34
 */
@RestController
@RequestMapping("dzu/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;
    //公司所有员工的工资统计  首页图二
    @GetMapping("/getChartBar")
    public R getChartBarData(){
        HashMap<String,Integer> map = salaryService.getCharBarData();
        return R.ok().put("salaryData",map);
    }


//    查询所有的员工薪资Form
    @GetMapping("/formList")
    public R getSalaryFormList(@RequestParam Map<String, Object> params){
        PageUtils page = salaryService.getSalaryFormList(params);
        return R.ok().put("page",page);
    }

//    通过eid查询员工工资
    @RequestMapping("/salaryEid/{eid}")
    public R getSalaryByEid(@PathVariable("eid") Long eid){
        SalaryEntity salary =  salaryService.getSalaryByid(eid);
        return R.ok().put("salary",salary);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = salaryService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SalaryEntity salary = salaryService.getById(id);

        return R.ok().put("salary", salary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SalaryEntity salary){
		salaryService.save(salary);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SalaryEntity salary){
		salaryService.updateById(salary);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		salaryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
