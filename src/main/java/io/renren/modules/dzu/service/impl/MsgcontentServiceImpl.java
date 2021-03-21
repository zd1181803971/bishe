package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.MsgcontentDao;
import io.renren.modules.dzu.entity.MsgcontentEntity;
import io.renren.modules.dzu.service.MsgcontentService;


@Service("msgcontentService")
public class MsgcontentServiceImpl extends ServiceImpl<MsgcontentDao, MsgcontentEntity> implements MsgcontentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MsgcontentEntity> page = this.page(
                new Query<MsgcontentEntity>().getPage(params),
                new QueryWrapper<MsgcontentEntity>()
        );

        return new PageUtils(page);
    }

}