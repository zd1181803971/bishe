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

import io.renren.modules.dzu.entity.CustomerLossEntity;
import io.renren.modules.dzu.service.CustomerLossService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 客户流失表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@RestController
@RequestMapping("dzu/customerloss")
public class CustomerLossController {
    @Autowired
    private CustomerLossService customerLossService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerLossService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CustomerLossEntity customerLoss = customerLossService.getById(id);

        return R.ok().put("customerLoss", customerLoss);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerLossEntity customerLoss){
		customerLossService.save(customerLoss);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerLossEntity customerLoss){
		customerLossService.updateById(customerLoss);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		customerLossService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
