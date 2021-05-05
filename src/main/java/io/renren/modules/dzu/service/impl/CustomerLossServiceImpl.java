package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.CustomerLossDao;
import io.renren.modules.dzu.entity.CustomerLossEntity;
import io.renren.modules.dzu.service.CustomerLossService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerLossService")
public class CustomerLossServiceImpl extends ServiceImpl<CustomerLossDao, CustomerLossEntity> implements CustomerLossService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerLossEntity> page = this.page(
                new Query<CustomerLossEntity>().getPage(params),
                getQueryWrapper(params)
        );

        return new PageUtils(page);
    }

//    .like("cusName",params.get("cusName"))
    public QueryWrapper<CustomerLossEntity> getQueryWrapper(Map<String, Object> params){
        QueryWrapper<CustomerLossEntity> customerLossEntityQueryWrapper = new QueryWrapper<>();
        if (params.get("cusName") != null){
            customerLossEntityQueryWrapper.like("cus_name",params.get("cusName"));
        }
        return customerLossEntityQueryWrapper;
    }

}
