package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.EmployeeremoveDao;
import io.renren.modules.dzu.entity.EmployeeremoveEntity;
import io.renren.modules.dzu.service.EmployeeremoveService;


@Service("employeeremoveService")
public class EmployeeremoveServiceImpl extends ServiceImpl<EmployeeremoveDao, EmployeeremoveEntity> implements EmployeeremoveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeremoveEntity> page = this.page(
                new Query<EmployeeremoveEntity>().getPage(params),
                new QueryWrapper<EmployeeremoveEntity>()
        );

        return new PageUtils(page);
    }

}