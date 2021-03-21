package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.JoblevelDao;
import io.renren.modules.dzu.entity.JoblevelEntity;
import io.renren.modules.dzu.service.JoblevelService;


@Service("joblevelService")
public class JoblevelServiceImpl extends ServiceImpl<JoblevelDao, JoblevelEntity> implements JoblevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JoblevelEntity> page = this.page(
                new Query<JoblevelEntity>().getPage(params),
                new QueryWrapper<JoblevelEntity>()
        );

        return new PageUtils(page);
    }

}