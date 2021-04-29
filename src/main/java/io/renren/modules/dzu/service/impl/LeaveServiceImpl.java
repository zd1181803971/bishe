package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dzu.dao.EmployeeDao;
import io.renren.modules.dzu.dao.LeaveDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.EmployeeecEntity;
import io.renren.modules.dzu.entity.LeaveEntity;
import io.renren.modules.dzu.entity.form.DeptForm;
import io.renren.modules.dzu.entity.form.LeaveForm;
import io.renren.modules.dzu.service.EmployeeecService;
import io.renren.modules.dzu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("leaveService")
public class LeaveServiceImpl extends ServiceImpl<LeaveDao, LeaveEntity> implements LeaveService {
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private EmployeeecService employeeecService;


    @Override
    public PageUtils getLeaveListByJob(Map<String, Object> params) {
        String jobNumber = null;
        if (params.get("jobNumber") != null && !"".equals(params.get("jobNumber"))) {
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

    @Override
    public R updateLeaveAndReportWork(LeaveEntity leave) {
        baseMapper.updateById(leave);
        Integer status = leave.getStatus();
        Date date1 = leave.getStartTime();
        Date date2 = leave.getEndTime();

        Instant instant = date1.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate startTime = instant.atZone(zoneId).toLocalDate();

        Instant instant2 = date2.toInstant();
        LocalDate endTime = instant2.atZone(zoneId).toLocalDate();


        LocalDate dateTemp = startTime;
//        long days = startTime.until(endTime, ChronoUnit.DAYS);
        LocalDate endTimeTemp = endTime.plusDays(1L);
//        通过
        if (status == 1) {
            while (dateTemp.isBefore(endTimeTemp)) {
                ZonedDateTime zdt = dateTemp.atStartOfDay(zoneId);
                Date date = Date.from(zdt.toInstant());
                EmployeeecEntity entity = new EmployeeecEntity();
                entity.setEid(leave.getEid());
                entity.setEctype(1);
                entity.setEchour(0L);
                entity.setEcdate(date);
                entity.setRemark(leave.getReason());
                employeeecService.save(entity);
                dateTemp = dateTemp.plusDays(1L);
            }
        }
        return R.ok();
    }

    @Override
    public R addLeave(LeaveEntity leave) {
        LeaveEntity eid = baseMapper.selectOne(new QueryWrapper<LeaveEntity>().eq("eid", leave.getEid()).eq("status", leave.getStatus()));
        LeaveEntity cancel = baseMapper.selectOne(new QueryWrapper<LeaveEntity>().eq("eid", leave.getEid()).eq("status", 1));
        if (eid != null) {
            return R.error("等待管理员审批后再次请假！");
        }
        if (cancel != null) {
            return R.error("请销假后再次请假！");

        }

        baseMapper.insert(leave);
        return R.ok();

    }
}




