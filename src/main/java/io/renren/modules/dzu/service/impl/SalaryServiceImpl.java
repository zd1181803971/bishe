package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.SalaryDao;
import io.renren.modules.dzu.entity.SalaryEntity;
import io.renren.modules.dzu.service.SalaryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("salaryService")
public class SalaryServiceImpl extends ServiceImpl<SalaryDao, SalaryEntity> implements SalaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<SalaryEntity> salaryEntityQueryWrapper = getQueryWrapper(params);
        IPage<SalaryEntity> page = this.page(
                new Query<SalaryEntity>().getPage(params),
                new QueryWrapper<SalaryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public SalaryEntity getSalaryByid(Long eid) {
        return  baseMapper.selectOne(new QueryWrapper<SalaryEntity>().eq("eid", eid));
    }

    public QueryWrapper<SalaryEntity> getQueryWrapper(Map<String, Object> params){
//        if (params.get("name"))
        return null;
    }


}
