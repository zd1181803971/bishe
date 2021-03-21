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

import io.renren.modules.dzu.entity.JoblevelEntity;
import io.renren.modules.dzu.service.JoblevelService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 员工职位等级表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/joblevel")
public class JoblevelController {
    @Autowired
    private JoblevelService joblevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = joblevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		JoblevelEntity joblevel = joblevelService.getById(id);

        return R.ok().put("joblevel", joblevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JoblevelEntity joblevel){
		joblevelService.save(joblevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JoblevelEntity joblevel){
		joblevelService.updateById(joblevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		joblevelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
