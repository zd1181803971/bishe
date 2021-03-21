package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.AppraiseDao;
import io.renren.modules.dzu.entity.AppraiseEntity;
import io.renren.modules.dzu.service.AppraiseService;


@Service("appraiseService")
public class AppraiseServiceImpl extends ServiceImpl<AppraiseDao, AppraiseEntity> implements AppraiseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppraiseEntity> page = this.page(
                new Query<AppraiseEntity>().getPage(params),
                new QueryWrapper<AppraiseEntity>()
        );

        return new PageUtils(page);
    }

}