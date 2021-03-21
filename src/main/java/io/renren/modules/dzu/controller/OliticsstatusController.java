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

import io.renren.modules.dzu.entity.OliticsstatusEntity;
import io.renren.modules.dzu.service.OliticsstatusService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 员工政治面貌表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/oliticsstatus")
public class OliticsstatusController {
    @Autowired
    private OliticsstatusService oliticsstatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oliticsstatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OliticsstatusEntity oliticsstatus = oliticsstatusService.getById(id);

        return R.ok().put("oliticsstatus", oliticsstatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OliticsstatusEntity oliticsstatus){
		oliticsstatusService.save(oliticsstatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OliticsstatusEntity oliticsstatus){
		oliticsstatusService.updateById(oliticsstatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		oliticsstatusService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
