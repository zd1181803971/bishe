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

import io.renren.modules.dzu.entity.AppraiseEntity;
import io.renren.modules.dzu.service.AppraiseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 员工考评表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/appraise")
public class AppraiseController {
    @Autowired
    private AppraiseService appraiseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = appraiseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AppraiseEntity appraise = appraiseService.getById(id);

        return R.ok().put("appraise", appraise);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AppraiseEntity appraise){
		appraiseService.save(appraise);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AppraiseEntity appraise){
		appraiseService.updateById(appraise);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		appraiseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
