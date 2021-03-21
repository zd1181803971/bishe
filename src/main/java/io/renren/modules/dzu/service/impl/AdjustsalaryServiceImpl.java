package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.AdjustsalaryDao;
import io.renren.modules.dzu.entity.AdjustsalaryEntity;
import io.renren.modules.dzu.service.AdjustsalaryService;


@Service("adjustsalaryService")
public class AdjustsalaryServiceImpl extends ServiceImpl<AdjustsalaryDao, AdjustsalaryEntity> implements AdjustsalaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdjustsalaryEntity> page = this.page(
                new Query<AdjustsalaryEntity>().getPage(params),
                new QueryWrapper<AdjustsalaryEntity>()
        );

        return new PageUtils(page);
    }

}