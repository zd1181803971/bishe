package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.CustomerEntity;
import io.renren.modules.dzu.entity.dto.EchartsCountDto;
import io.renren.modules.dzu.entity.form.SelectForm;
import io.renren.modules.dzu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 客户表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@RestController
@RequestMapping("dzu/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    /**
     * 获取客户姓名select
     * @return
     */
    @GetMapping("/getCustomerAllNames")
    public R getCustomerAllNamesBySelect(){
        List<SelectForm> list = customerService.getCustomerAllNamesBySelect();
        return R.ok().put("list",list);
    }
    /**
     * 获取客户级别echarts统计数
     * @return
     */
    @RequestMapping("/getCustomerByEcharts")
    public R getCustomerCountByEcharts(){
        List<EchartsCountDto> list = customerService.getCustomerCountByEcharts();
        return R.ok().put("list",list);
    }
    /**
     * 流失客户 并添加流失记录
     * @param customer
     * @return
     */
    @RequestMapping("/lossCustomer")
    public R lossCustomer(@RequestBody CustomerEntity customer){
        R r = customerService.lossCustomer(customer);
        return r;
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CustomerEntity customer = customerService.getById(id);

        return R.ok().put("customer", customer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerEntity customer){
        return  customerService.saveCustomer(customer);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerEntity customer){
        customer.setUpdateDate(new Date());
		customerService.updateById(customer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		customerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
