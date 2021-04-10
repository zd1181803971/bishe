package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.EmployeeecDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.EmployeeecEntity;
import io.renren.modules.dzu.entity.dto.EmpClockDto;
import io.renren.modules.dzu.service.EmployeeService;
import io.renren.modules.dzu.service.EmployeeecService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("employeeecService")
public class EmployeeecServiceImpl extends ServiceImpl<EmployeeecDao, EmployeeecEntity> implements EmployeeecService {

    @Autowired
    private EmployeeecDao employeeecDao;
    @Autowired
    private EmployeeService employeeService;

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
        if (StringUtils.isNotEmpty((String) params.get("empTime"))){
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

    @Override
    public  HashMap<String, Integer> getEmpClock() {
        int[] count = new int[]{0,0,0,0};
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<EmpClockDto> list =  employeeecDao.getEmpClockData();
        for (EmpClockDto empClockDto: list){
            if ("0".equals(empClockDto.getStatus())){
                hashMap.put("正常报工",++count[0]);
            }
            if ("1".equals(empClockDto.getStatus())){
                hashMap.put("请假",++count[1]);
            }
            if ("2".equals(empClockDto.getStatus())){
                hashMap.put("矿工",++count[2]);

            }
            if (empClockDto.getStatus() == null){
                hashMap.put("今日还未报工",++count[3]);
            }
        }
        return hashMap;
    }

    @Override
    public EmployeeecEntity getEmpClockByEid(String eid) {
        EmployeeEntity jobNumber = employeeService.getOne(new QueryWrapper<EmployeeEntity>().eq("jobNumber", eid));
        LocalDate today = LocalDate.now();
        if (StringUtils.isNotEmpty(eid)){
            EmployeeecEntity one = this.getOne(new QueryWrapper<EmployeeecEntity>().eq("eid", jobNumber.getId()).eq("ecDate", today));
            if (one != null){
                return one;
            }
        }
        return null;
    }


}
