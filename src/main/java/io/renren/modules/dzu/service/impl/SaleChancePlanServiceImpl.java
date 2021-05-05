package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.SaleChancePlanDao;
import io.renren.modules.dzu.entity.SaleChancePlanEntity;
import io.renren.modules.dzu.service.SaleChancePlanService;


@Service("saleChancePlanService")
public class SaleChancePlanServiceImpl extends ServiceImpl<SaleChancePlanDao, SaleChancePlanEntity> implements SaleChancePlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SaleChancePlanEntity> page = this.page(
                new Query<SaleChancePlanEntity>().getPage(params),
                new QueryWrapper<SaleChancePlanEntity>()
        );

        return new PageUtils(page);
    }

}