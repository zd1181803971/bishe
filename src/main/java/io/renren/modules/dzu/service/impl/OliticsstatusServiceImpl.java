package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.OliticsstatusDao;
import io.renren.modules.dzu.entity.OliticsstatusEntity;
import io.renren.modules.dzu.service.OliticsstatusService;


@Service("oliticsstatusService")
public class OliticsstatusServiceImpl extends ServiceImpl<OliticsstatusDao, OliticsstatusEntity> implements OliticsstatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OliticsstatusEntity> page = this.page(
                new Query<OliticsstatusEntity>().getPage(params),
                new QueryWrapper<OliticsstatusEntity>()
        );

        return new PageUtils(page);
    }

}