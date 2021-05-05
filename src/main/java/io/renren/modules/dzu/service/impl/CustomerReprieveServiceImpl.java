package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.CustomerReprieveDao;
import io.renren.modules.dzu.entity.CustomerReprieveEntity;
import io.renren.modules.dzu.service.CustomerReprieveService;


@Service("customerReprieveService")
public class CustomerReprieveServiceImpl extends ServiceImpl<CustomerReprieveDao, CustomerReprieveEntity> implements CustomerReprieveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerReprieveEntity> page = this.page(
                new Query<CustomerReprieveEntity>().getPage(params),
                new QueryWrapper<CustomerReprieveEntity>()
        );

        return new PageUtils(page);
    }

}