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

import io.renren.modules.dzu.entity.CustomerReprieveEntity;
import io.renren.modules.dzu.service.CustomerReprieveService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 客户流失暂缓表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@RestController
@RequestMapping("dzu/customerreprieve")
public class CustomerReprieveController {
    @Autowired
    private CustomerReprieveService customerReprieveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerReprieveService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CustomerReprieveEntity customerReprieve = customerReprieveService.getById(id);

        return R.ok().put("customerReprieve", customerReprieve);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerReprieveEntity customerReprieve){
		customerReprieveService.save(customerReprieve);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerReprieveEntity customerReprieve){
		customerReprieveService.updateById(customerReprieve);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		customerReprieveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
