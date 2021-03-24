package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.OliticsstatusEntity;
import io.renren.modules.dzu.service.OliticsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



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
     * 不传参数返回所有的数据
     */
    @RequestMapping("/listAll")
    public R listAll(){
        List<OliticsstatusEntity> list = oliticsstatusService.list();
        return R.ok().put("page", list);
    }
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
