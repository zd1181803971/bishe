package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.NationDao;
import io.renren.modules.dzu.entity.NationEntity;
import io.renren.modules.dzu.service.NationService;


@Service("nationService")
public class NationServiceImpl extends ServiceImpl<NationDao, NationEntity> implements NationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NationEntity> page = this.page(
                new Query<NationEntity>().getPage(params),
                new QueryWrapper<NationEntity>()
        );

        return new PageUtils(page);
    }

}