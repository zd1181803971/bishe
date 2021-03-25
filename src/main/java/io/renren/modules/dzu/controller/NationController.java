package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.NationEntity;
import io.renren.modules.dzu.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 员工民族表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/nation")
public class NationController {
    @Autowired
    private NationService nationService;

//    获取民族以及人数NationForm表单
    @GetMapping("/getNationForm")
    public R getNationForm(@RequestParam Map<String, Object> params){
        PageUtils page = nationService.getNationForm(params);
        return R.ok().put("nationForm",page);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nationService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 不传参数就返回所有的数据
     *
     */
    @GetMapping("/listAll")
    public R listAllNation(){
        List<NationEntity> list = nationService.list();
        return R.ok().put("page", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		NationEntity nation = nationService.getById(id);
        return R.ok().put("nation", nation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NationEntity nation){
		nationService.save(nation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NationEntity nation){
		nationService.updateById(nation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		nationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
