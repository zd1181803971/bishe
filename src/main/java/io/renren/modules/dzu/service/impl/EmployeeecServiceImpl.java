package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.EmployeeecDao;
import io.renren.modules.dzu.entity.EmployeeecEntity;
import io.renren.modules.dzu.service.EmployeeecService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@Service("employeeecService")
public class EmployeeecServiceImpl extends ServiceImpl<EmployeeecDao, EmployeeecEntity> implements EmployeeecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeecEntity> page = this.page(
                new Query<EmployeeecEntity>().getPage(params),
                getQueryWrapper(params)
        );

        return new PageUtils(page);
    }

    public QueryWrapper<EmployeeecEntity> getQueryWrapper(Map<String, Object> params){
        QueryWrapper<EmployeeecEntity> employeeecEntityQueryWrapper = new QueryWrapper<>();
        DateTimeFormatter fmDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String name = null;
        LocalDate localDate =null;
        if (StringUtils.isNotEmpty((String) params.get("name"))){
            name = params.get("name").toString();
            employeeecEntityQueryWrapper.eq("eid",name);
        }
        if (StringUtils.isNotEmpty(params.get("empTime").toString())){
            localDate =   LocalDate.parse(params.get("empTime").toString(), fmDate);
            employeeecEntityQueryWrapper.eq("ecDate",localDate);
        }
        return employeeecEntityQueryWrapper;
    }
    @Override
    public PageUtils queryPage2(Map<String, Object> params) {
        DateTimeFormatter fmDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        IPage<EmployeeecEntity> page = this.page(
                new Query<EmployeeecEntity>().getPage(params),
                new QueryWrapper<EmployeeecEntity>().eq("ecDate",today.format(fmDate))
        );

        return new PageUtils(page);
    }


}
