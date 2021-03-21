package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.EmployeeecDao;
import io.renren.modules.dzu.entity.EmployeeecEntity;
import io.renren.modules.dzu.service.EmployeeecService;


@Service("employeeecService")
public class EmployeeecServiceImpl extends ServiceImpl<EmployeeecDao, EmployeeecEntity> implements EmployeeecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeecEntity> page = this.page(
                new Query<EmployeeecEntity>().getPage(params),
                new QueryWrapper<EmployeeecEntity>()
        );

        return new PageUtils(page);
    }

}