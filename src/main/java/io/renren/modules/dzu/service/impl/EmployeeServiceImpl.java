package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.EmployeeDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.service.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {


    @Override
    public EmployeeEntity getEmployeeByjobNumber(String jobnumber) {
        EmployeeEntity entity = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("jobNumber", jobnumber));
        return entity;
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeEntity> page = this.page(
                new Query<EmployeeEntity>().getPage(params),
                getEmployeeByName(params)
        );
        return new PageUtils(page);
    }



    public QueryWrapper<EmployeeEntity> getEmployeeByName(Map<String, Object> params){
        if (StringUtils.isNotEmpty((String) params.get("name"))){
            return new QueryWrapper<EmployeeEntity>().eq("name",params.get("name"));
        }else {
            return new QueryWrapper<EmployeeEntity>();
        }
    }
}
