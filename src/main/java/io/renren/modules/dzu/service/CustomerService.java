package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.CustomerEntity;
import io.renren.modules.dzu.entity.dto.EchartsCountDto;
import io.renren.modules.dzu.entity.form.SelectForm;

import java.util.List;
import java.util.Map;

/**
 * 客户表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
public interface CustomerService extends IService<CustomerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 更新客户流失状态，添加流失客户记录
     * @param customer
     * @return
     */
    R lossCustomer(CustomerEntity customer);

    List<EchartsCountDto> getCustomerCountByEcharts();

    List<SelectForm> getCustomerAllNamesBySelect();

    R saveCustomer(CustomerEntity customer);
}

