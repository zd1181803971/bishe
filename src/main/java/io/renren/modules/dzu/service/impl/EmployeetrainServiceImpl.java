package io.renren.modules.dzu.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.dzu.dao.EmployeetrainDao;
import io.renren.modules.dzu.entity.EmployeetrainEntity;
import io.renren.modules.dzu.service.EmployeetrainService;


@Service("employeetrainService")
public class EmployeetrainServiceImpl extends ServiceImpl<EmployeetrainDao, EmployeetrainEntity> implements EmployeetrainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeetrainEntity> page = this.page(
                new Query<EmployeetrainEntity>().getPage(params),
                new QueryWrapper<EmployeetrainEntity>()
        );

        return new PageUtils(page);
    }

}