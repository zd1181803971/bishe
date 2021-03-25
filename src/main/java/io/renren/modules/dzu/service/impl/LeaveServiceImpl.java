package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.EmployeeDao;
import io.renren.modules.dzu.dao.LeaveDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.LeaveEntity;
import io.renren.modules.dzu.entity.form.DeptForm;
import io.renren.modules.dzu.entity.form.LeaveForm;
import io.renren.modules.dzu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("leaveService")
public class LeaveServiceImpl extends ServiceImpl<LeaveDao, LeaveEntity> implements LeaveService {
    @Autowired
    LeaveDao leaveDao;
    @Autowired
    EmployeeServiceImpl employeeService;


    @Override
    public PageUtils getLeaveListByJob(Map<String, Object> params) {
        String jobNumber = null;
        if (params.get("jobNumber") != null && !params.get("jobNumber").equals("")) {
            jobNumber = params.get("jobNumber").toString();

        }
        IPage<DeptForm> page = new Query<DeptForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<LeaveEntity> leaveListByJob = leaveDao.getLeaveListByJob(jobNumber);
        PageInfo<LeaveEntity> leaveEntityPageInfo = new PageInfo<>(leaveListByJob);
        return new PageUtils(leaveEntityPageInfo.getList(),
                (int) leaveEntityPageInfo.getTotal(),
                leaveEntityPageInfo.getSize(),
                leaveEntityPageInfo.getPageNum());
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LeaveEntity> page = this.page(
                new Query<LeaveEntity>().getPage(params),
                getLeaveByEid(params)
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils getLeaveFormList(Map<String, Object> params) {
        List<LeaveForm> list;
        if (params.get("name") != null) {
            list = leaveDao.getLeaveFormList(params.get("name").toString());
        } else {
            list = leaveDao.getLeaveFormList(null);
        }
        IPage<LeaveForm> page = new Query<LeaveForm>().getPage(params);
        return new PageUtils(list, (int) page.getTotal(), (int) page.getSize(), (int) page.getCurrent());
    }


    public QueryWrapper<LeaveEntity> getLeaveByEid(Map<String, Object> params) {
        QueryWrapper<LeaveEntity> leaveEntityQueryWrapper = new QueryWrapper<>();
        if (params.get("eid") != null && params.get("eid") != "") {
            String eid = (String) params.get("eid");
            leaveEntityQueryWrapper.eq("eid", eid);
        } else if (params.get("name") != null && params.get("name").hashCode() == 0) {
            String name = (String) params.get("name");
            EmployeeDao baseMapper = employeeService.getBaseMapper();
            EmployeeEntity employeeEntities = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("name", name));
            Long id = employeeEntities.getId();
            leaveEntityQueryWrapper.eq("eid", id);
        } else {
            return leaveEntityQueryWrapper.orderByAsc("status");
        }
        return leaveEntityQueryWrapper.orderByAsc("status");
    }
}




