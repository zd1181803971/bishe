package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.EmployeeDao;
import io.renren.modules.dzu.dao.LeaveDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.LeaveEntity;
import io.renren.modules.dzu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("leaveService")
public class LeaveServiceImpl extends ServiceImpl<LeaveDao, LeaveEntity> implements LeaveService {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LeaveEntity> page = this.page(
                new Query<LeaveEntity>().getPage(params),
                getLeaveByEid(params)
        );
        return new PageUtils(page);
    }

    public QueryWrapper<LeaveEntity> getLeaveByEid(Map<String, Object> params) {
        QueryWrapper<LeaveEntity> leaveEntityQueryWrapper = new QueryWrapper<>();
        if (params.get("eid") != null && params.get("eid") != "") {
            String eid = (String) params.get("eid");
            leaveEntityQueryWrapper.eq("eid", eid);
        } else if (params.get("name") != null && params.get("name").hashCode() == 0) {
            String name = (String) params.get("name");
            EmployeeDao baseMapper = employeeService.getBaseMapper();
            EmployeeEntity employeeEntities = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("name",name));
            Long id = employeeEntities.getId();
            leaveEntityQueryWrapper.eq("eid", id);
        }
        else {
            return leaveEntityQueryWrapper.orderByAsc("status");
        }
        return leaveEntityQueryWrapper.orderByAsc("status");
    }
}
//        if (params.get("name") != null){
//            String name = (String) params.get("name");
//            return new QueryWrapper<LeaveEntity>().eq("eid",eid).orderByAsc("status");
//        }else {
//            return new QueryWrapper<LeaveEntity>().orderByAsc("status");
//        }


