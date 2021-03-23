package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.EmployeeDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.form.EmployeeForm;
import io.renren.modules.dzu.entity.form.SalaryForm;
import io.renren.modules.dzu.service.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public PageUtils getEmpFormList(Map<String, Object> map) {
        List<EmployeeForm> list;
        if (map.get("name")!=null){
            list = employeeDao.getEmpFormList(map.get("name").toString());
        }else {
            list = employeeDao.getEmpFormList(null);
        }
        IPage<EmployeeForm> page = new Query<EmployeeForm>().getPage(map);
        return new PageUtils(list,(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent());
    }


    @Override
    public EmployeeEntity getEmployeeByjobNumber(String jobnumber) {
        EmployeeEntity entity = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("jobNumber", jobnumber));
        return entity;
    }

    @Override
    public List<EmployeeEntity> getEmpByIds(Map<String, Object> map) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (map.get("ids") != null){
            String ids = (String) map.get("ids");
            String[] split = ids.split(",");
            for (String s : split){
                if (StringUtils.isNotEmpty(s)){
                    integers.add(Integer.parseInt(s));
                }
            }

        }
        if (integers.size() != 0){
            return baseMapper.selectBatchIds(integers);
        }else {
            return null;
        }
    }

    @Override
    public HashMap<String, Integer> getChartLineData() {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<EmployeeEntity> entityList = baseMapper.selectList(null);
        int j = 1;
        for (int i = 0; i < entityList.size(); i++) {
            if (!arrayList.contains(entityList.get(i).getSchool())){
                arrayList.add(entityList.get(i).getSchool());
                hashMap.put(entityList.get(i).getSchool(),j);
            }else {
                Integer integer = hashMap.get(entityList.get(i).getSchool());
                integer++;
                hashMap.put(entityList.get(i).getSchool(),integer);
            }
        }
        return hashMap;
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
