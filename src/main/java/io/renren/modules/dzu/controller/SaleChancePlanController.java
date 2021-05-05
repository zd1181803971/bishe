package io.renren.modules.dzu.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dzu.entity.SaleChancePlanEntity;
import io.renren.modules.dzu.service.SaleChancePlanService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 营销管理计划表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@RestController
@RequestMapping("dzu/salechanceplan")
public class SaleChancePlanController {
    @Autowired
    private SaleChancePlanService saleChancePlanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = saleChancePlanService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SaleChancePlanEntity saleChancePlan = saleChancePlanService.getById(id);

        return R.ok().put("saleChancePlan", saleChancePlan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaleChancePlanEntity saleChancePlan){
		saleChancePlanService.save(saleChancePlan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SaleChancePlanEntity saleChancePlan){
		saleChancePlanService.updateById(saleChancePlan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		saleChancePlanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
