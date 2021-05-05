package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.SaleChanceEntity;
import io.renren.modules.dzu.service.SaleChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 营销机会表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@RestController
@RequestMapping("dzu/salechance")
public class SaleChanceController {
    @Autowired
    private SaleChanceService saleChanceService;


    /**
     * 获取个人需要开发的营销计划
     * @param params
     * @return
     */
    @GetMapping("listFormByAssignEmp")
    public R getListFormByAssignEmp(@RequestParam Map<String, Object> params){
        PageUtils page = saleChanceService.getListFormByAssignEmp(params);
        return R.ok().put("page", page);
    }

    /**
     * 前端表单页面
     * @param params
     * @return
     */
    @GetMapping("/listForm")
    public R getFormList(@RequestParam Map<String, Object> params){
        PageUtils page = saleChanceService.getListForm(params);
        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = saleChanceService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SaleChanceEntity saleChance = saleChanceService.getById(id);

        return R.ok().put("saleChance", saleChance);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaleChanceEntity saleChance){
        if (saleChance.getAssignMan() != null){
            saleChance.setAssignTime(new Date());
            saleChance.setAllocationState(1);
            saleChance.setDevResult(1);
            saleChance.setCreateDate(new Date());
        }
        if (saleChance.getAssignMan() == null){
            saleChance.setAllocationState(0);
            saleChance.setDevResult(0);
            saleChance.setCreateDate(new Date());
        }
		saleChanceService.save(saleChance);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SaleChanceEntity saleChance){
        if (saleChance.getAssignMan() != null){
            saleChance.setAssignTime(new Date());
            saleChance.setAllocationState(1);
            saleChance.setDevResult(1);
        }
        saleChance.setUpdateDate(new Date());

		saleChanceService.updateById(saleChance);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		saleChanceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
